package it.xsemantics.dsl.ui.outline

import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Description
import it.xsemantics.dsl.xsemantics.Injected
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Named
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.XsemanticsFile
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.ITextRegion

/**
 * customization of the default outline structure
 * 
 */
public class XsemanticsOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	def protected void _createChildren(DocumentRootNode parentNode, XsemanticsFile it) {
		// skip useless toplevel node and imports - start tree with node for "system" 
		createChildren(parentNode, it.getXsemanticsSystem())
	}
	
	def protected void _createChildren(IOutlineNode parentNode, XsemanticsSystem it) {
		// skip imports
		// injections
		createNodesFor(parentNode, it.getInjections())
		// auxiliary descriptions
		createGroupedNodesForAuxliary(parentNode, it)
		// judgment descriptions
		createGroupedNodesForJudgements(parentNode, it)
		// skip auxiliary functions
		// skip rules
		// checkrules
		createNodesFor(parentNode, it.getCheckrules())
	}
	
	def private <T extends EObject> void createNodesFor(IOutlineNode parentNode, Iterable<T> items){
		for(T item: items){
			createNode(parentNode, item)
		}
	}
	
	def private void createGroupedNodesForAuxliary(IOutlineNode parentNode, XsemanticsSystem it){
		val rootNodes = newLinkedHashSet
		rootNodes.addAll(auxiliaryDescriptions)		// all "local" descriptions
		rootNodes.addAll(auxiliaryFunctions.map[get_auxiliaryDescription])	// all descriptions of superSystems which have functions in this file
		createNodesFor(parentNode, rootNodes)
	}
	
	def private void createGroupedNodesForJudgements(IOutlineNode parentNode, XsemanticsSystem it){
		val rootNodes = newLinkedHashSet
		rootNodes.addAll(judgmentDescriptions)		// all "local" descriptions
		rootNodes.addAll(rules.map[get_judgment])	// all descriptions of superSystems which have rules in this file
		createNodesFor(parentNode, rootNodes)
	}
	
	
	def protected void _createNode(IOutlineNode parentNode, AuxiliaryDescription it) {
		val node = createEObjectNode(parentNode, it)
		
		// Merge all text regions from the description and all relevant functions to support editor to outline jumps.
		val childrenProvider = [XsemanticsSystem system | system.auxiliaryFunctions.filter[ function | function.get_auxiliaryDescription == it ] ]
		node.textRegion = calculateGroupedTextRegion(node, it, childrenProvider)
	}
	
	def protected void _createNode(IOutlineNode parentNode, JudgmentDescription it) {
		val node = createEObjectNode(parentNode, it)
		
		// Merge all text regions from the judgement and all relevant rules to support editor to outline jumps.
		val childrenProvider = [XsemanticsSystem system | system.rules.filter[ rule | rule.get_judgment == it ] ]
		node.textRegion = calculateGroupedTextRegion(node, it, childrenProvider)
	}
	
	def private ITextRegion calculateGroupedTextRegion(IOutlineNode node, Description it, (XsemanticsSystem) => Iterable<? extends Named> childrenProvider){
		val parentRegion = if (isLocalElement(node, it) ) node.fullTextRegion else ITextRegion.EMPTY_REGION
		var xsemanticsSystem = getXsemanticsSystem(node.parent, it)
		mergeRegions(parentRegion, childrenProvider.apply(xsemanticsSystem))
	}
	
	def private mergeRegions(ITextRegion startRegion, Iterable<? extends EObject> items){
		var region = startRegion
		for(EObject eo: items){
			val parserNode = NodeModelUtils.getNode(eo);
			if( parserNode != null )
				region = region.merge(parserNode.textRegion)
		}
		region
	}
	
	def protected void _createChildren(IOutlineNode parentNode, AuxiliaryDescription it) {
		val xsemanticsSystem = getXsemanticsSystem(parentNode.parent, it)
		createNodesFor(parentNode, xsemanticsSystem.auxiliaryFunctions.filter[ function | function.get_auxiliaryDescription == it ])
	}
	
	def protected void _createChildren(IOutlineNode parentNode, JudgmentDescription it) {
		val xsemanticsSystem = getXsemanticsSystem(parentNode.parent, it)
		createNodesFor(parentNode, xsemanticsSystem.rules.filter[rule | rule.get_judgment == it ])
	}
	
	
	def protected boolean _isLeaf(Rule rule) {
		return true
	}

	def protected boolean _isLeaf(CheckRule rule) {
		return true
	}

	def protected boolean _isLeaf(JudgmentDescription desc) {
		return false
	}

	def protected boolean _isLeaf(AuxiliaryDescription desc) {
		return false
	}

	def protected boolean _isLeaf(AuxiliaryFunction aux) {
		return true
	}

	def protected boolean _isLeaf(Injected i) {
		return true
	}
	
	def private XsemanticsSystem  getXsemanticsSystem(IOutlineNode parentNode, Description description){
		if( isLocalElement(parentNode, description) ){
			EcoreUtil2.getContainerOfType(description, XsemanticsSystem)
		}
		else {
			// Do not use the actual description to get the system, because the description is in a different resource.
			parentNode.xsemanticsSystem
		}
	}
	
	def private dispatch XsemanticsSystem getXsemanticsSystem(IOutlineNode it){
		null
	}
	
	def private dispatch XsemanticsSystem getXsemanticsSystem(DocumentRootNode it){
		throw new RuntimeException("due to a bug in Xtext readOnly on DocumentRootNode will always return null.")
//		readOnly[ eo | 
//			val xsFile = eo as XsemanticsFile
//			xsFile.xsemanticsSystem
//		]
	}
	
	def private dispatch XsemanticsSystem getXsemanticsSystem(EObjectNode it){
		readOnly[ eo | 
			EcoreUtil2.getContainerOfType(eo, XsemanticsSystem)
		]
	}
}
