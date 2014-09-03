/*
 * generated by Xtext
 */
package it.xsemantics.dsl.ui.contentassist

import com.google.inject.Inject
import it.xsemantics.dsl.services.XsemanticsProposalsForDatatypeRules
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.validation.AbstractDeclarativeValidator

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class XsemanticsProposalProvider extends AbstractXsemanticsProposalProvider {
	
	@Inject ITypesProposalProvider typeProposalProvider

	@Inject IJvmTypeProvider.Factory typeProviderFactory
	
	@Inject XsemanticsProposalsForDatatypeRules proposalsForDatatypeRules
	
	override void complete_JudgmentSymbol(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		for (String symbol : proposalsForDatatypeRules.judgmentSymbols()) {
			acceptor.accept(createCompletionProposal(symbol, context));
		}
	}

	override void complete_RelationSymbol(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		for (String symbol : proposalsForDatatypeRules.relationSymbols()) {
			acceptor.accept(createCompletionProposal(symbol, context));
		}
	}

	override void completeXsemanticsSystem_ValidatorExtends(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// we show only subtypes of AbstractDeclarativeValidator
		showOnlySubtypesOf(model, context, acceptor,
				AbstractDeclarativeValidator);
	}

	override void completeXsemanticsSystem_SuperSystem(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// we show only subtypes of XsemanticsRuntimeSystem
		showOnlySubtypesOf(model, context, acceptor,
				XsemanticsRuntimeSystem);
	}

	def private void showOnlySubtypesOf(EObject model,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			Class<?> superType) {

		val jvmTypeProvider = typeProviderFactory
				.createTypeProvider(model.eResource().getResourceSet());
		val interfaceToImplement = jvmTypeProvider
				.findTypeByName(superType.getName());
		typeProposalProvider.createSubTypeProposals(interfaceToImplement, this,
				context,
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
				acceptor);
	}
}