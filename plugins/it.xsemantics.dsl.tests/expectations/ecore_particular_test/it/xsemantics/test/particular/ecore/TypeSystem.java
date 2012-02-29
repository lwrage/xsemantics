package it.xsemantics.test.particular.ecore;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class TypeSystem extends XsemanticsRuntimeSystem {
	public final static String ECLASSEOBJECT = "it.xsemantics.test.particular.ecore.rules.EClassEObject";
	public final static String ECLASSEOBJECT2 = "it.xsemantics.test.particular.ecore.rules.EClassEObject2";
	public final static String FEATURES = "it.xsemantics.test.particular.ecore.rules.Features";
	public final static String COLELCTIONS = "it.xsemantics.test.particular.ecore.rules.Colelctions";
	public final static String FOREACH = "it.xsemantics.test.particular.ecore.rules.ForEach";
	public final static String FOREACHWITHBOOLEANEXPRESSIONINSIDE = "it.xsemantics.test.particular.ecore.rules.ForEachWithBooleanExpressionInside";
	public final static String WITHFAIL = "it.xsemantics.test.particular.ecore.rules.WithFail";
	public final static String TESTFORCLOSURES = "it.xsemantics.test.particular.ecore.rules.TestForClosures";
	public final static String TESTFORENVIRONMENTS = "it.xsemantics.test.particular.ecore.rules.TestForEnvironments";

	protected PolymorphicDispatcher<Result<EObject>> typeDispatcher;
	
	protected PolymorphicDispatcher<Result2<EClass, EObject>> type2Dispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> type1Dispatcher;
	
	protected PolymorphicDispatcher<Result<List<EStructuralFeature>>> featuresDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> collectionsDispatcher;
	
	protected PolymorphicDispatcher<Result<EClass>> type3Dispatcher;
	
	protected PolymorphicDispatcher<Result<EClass>> withfailDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> closuresDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> environmentsDispatcher;

	public TypeSystem() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 3, "|-", ":");
		type2Dispatcher = buildPolymorphicDispatcher2(
			"type2Impl", 3, "||-", ":", ":");
		type1Dispatcher = buildPolymorphicDispatcher1(
			"type1Impl", 3, "|-");
		featuresDispatcher = buildPolymorphicDispatcher1(
			"featuresImpl", 3, "|-", ">>");
		collectionsDispatcher = buildPolymorphicDispatcher1(
			"collectionsImpl", 4, "|-", "|>");
		type3Dispatcher = buildPolymorphicDispatcher1(
			"type3Impl", 3, "||-", ":");
		withfailDispatcher = buildPolymorphicDispatcher1(
			"withfailImpl", 3, "|~", ":");
		closuresDispatcher = buildPolymorphicDispatcher1(
			"closuresImpl", 3, "||~");
		environmentsDispatcher = buildPolymorphicDispatcher1(
			"environmentsImpl", 3, "||-");
	}

	public Result<EObject> type(final EClass c) {
		return type(new RuleEnvironment(),
			null, c);
	}
	
	public Result<EObject> type(final RuleEnvironment _environment_,
			final EClass c) {
		return type(_environment_,
			null, c);
	}
	
	public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			return typeInternal(_environment_, _trace_, c);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result2<EClass, EObject> type2(final String s) {
		return type2(new RuleEnvironment(),
			null, s);
	}
	
	public Result2<EClass, EObject> type2(final RuleEnvironment _environment_,
			final String s) {
		return type2(_environment_,
			null, s);
	}
	
	public Result2<EClass, EObject> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final String s) {
		try {
			return type2Internal(_environment_, _trace_, s);
		} catch (Exception e) {
			return resultForFailure2(e);
		}
	}
	
	public Result<Boolean> type1(final EObject o) {
		return type1(new RuleEnvironment(),
			null, o);
	}
	
	public Result<Boolean> type1(final RuleEnvironment _environment_,
			final EObject o) {
		return type1(_environment_,
			null, o);
	}
	
	public Result<Boolean> type1(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o) {
		try {
			return type1Internal(_environment_, _trace_, o);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<List<EStructuralFeature>> features(final EClass c1) {
		return features(new RuleEnvironment(),
			null, c1);
	}
	
	public Result<List<EStructuralFeature>> features(final RuleEnvironment _environment_,
			final EClass c1) {
		return features(_environment_,
			null, c1);
	}
	
	public Result<List<EStructuralFeature>> features(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c1) {
		try {
			return featuresInternal(_environment_, _trace_, c1);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> collections(final EClass c2, final List<EStructuralFeature> l2) {
		return collections(new RuleEnvironment(),
			null, c2, l2);
	}
	
	public Result<Boolean> collections(final RuleEnvironment _environment_,
			final EClass c2, final List<EStructuralFeature> l2) {
		return collections(_environment_,
			null, c2, l2);
	}
	
	public Result<Boolean> collections(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c2, final List<EStructuralFeature> l2) {
		try {
			return collectionsInternal(_environment_, _trace_, c2, l2);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<EClass> type3(final EObject o2) {
		return type3(new RuleEnvironment(),
			null, o2);
	}
	
	public Result<EClass> type3(final RuleEnvironment _environment_,
			final EObject o2) {
		return type3(_environment_,
			null, o2);
	}
	
	public Result<EClass> type3(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o2) {
		try {
			return type3Internal(_environment_, _trace_, o2);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<EClass> withfail(final EObject o2) {
		return withfail(new RuleEnvironment(),
			null, o2);
	}
	
	public Result<EClass> withfail(final RuleEnvironment _environment_,
			final EObject o2) {
		return withfail(_environment_,
			null, o2);
	}
	
	public Result<EClass> withfail(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o2) {
		try {
			return withfailInternal(_environment_, _trace_, o2);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> closures(final EClass eClass) {
		return closures(new RuleEnvironment(),
			null, eClass);
	}
	
	public Result<Boolean> closures(final RuleEnvironment _environment_,
			final EClass eClass) {
		return closures(_environment_,
			null, eClass);
	}
	
	public Result<Boolean> closures(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass eClass) {
		try {
			return closuresInternal(_environment_, _trace_, eClass);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> environments(final EClass eClass) {
		return environments(new RuleEnvironment(),
			null, eClass);
	}
	
	public Result<Boolean> environments(final RuleEnvironment _environment_,
			final EClass eClass) {
		return environments(_environment_,
			null, eClass);
	}
	
	public Result<Boolean> environments(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass eClass) {
		try {
			return environmentsInternal(_environment_, _trace_, eClass);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}


	protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			checkParamsNotNull(c);
			return typeDispatcher.invoke(_environment_, _trace_, c);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result2<EClass, EObject> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final String s) {
		try {
			checkParamsNotNull(s);
			return type2Dispatcher.invoke(_environment_, _trace_, s);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> type1Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o) {
		try {
			checkParamsNotNull(o);
			return type1Dispatcher.invoke(_environment_, _trace_, o);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<List<EStructuralFeature>> featuresInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c1) {
		try {
			checkParamsNotNull(c1);
			return featuresDispatcher.invoke(_environment_, _trace_, c1);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> collectionsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c2, final List<EStructuralFeature> l2) {
		try {
			checkParamsNotNull(c2, l2);
			return collectionsDispatcher.invoke(_environment_, _trace_, c2, l2);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<EClass> type3Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o2) {
		try {
			checkParamsNotNull(o2);
			return type3Dispatcher.invoke(_environment_, _trace_, o2);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<EClass> withfailInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject o2) {
		try {
			checkParamsNotNull(o2);
			return withfailDispatcher.invoke(_environment_, _trace_, o2);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> closuresInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass eClass) {
		try {
			checkParamsNotNull(eClass);
			return closuresDispatcher.invoke(_environment_, _trace_, eClass);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> environmentsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass eClass) {
		try {
			checkParamsNotNull(eClass);
			return environmentsDispatcher.invoke(_environment_, _trace_, eClass);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<EObject> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass _createEObject) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<EObject> _result_ = applyRuleEClassEObject(G, _subtrace_, _createEObject);
			addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(_createEObject) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEClassEObject) {
			throwRuleFailedException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(_createEObject) + " : " + "EObject",
				ECLASSEOBJECT,
				e_applyRuleEClassEObject, new ErrorInformation(_createEObject));
			return null;
		}
	}
	
	protected Result<EObject> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass _createEObject) 
			throws RuleFailedException {
		
		String _string = new String();
		String _firstUpper = StringExtensions.toFirstUpper("bar");
		String _operator_plus = StringExtensions.operator_plus(_string, _firstUpper);
		boolean _operator_equals = ObjectExtensions.operator_equals("foo", _operator_plus);
		/* 'foo' == new String() + 'bar'.toFirstUpper */
		if (!_operator_equals) {
		  sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
		}
		EObject _createEObject_1 = EcoreFactory.eINSTANCE.createEObject();
		return new Result<EObject>(_createEObject_1);
	}
	
	protected Result2<EClass, EObject> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final String s) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<EClass, EObject> _result_ = applyRuleEClassEObject2(G, _subtrace_, s);
			addToTrace(_trace_, ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(s) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEClassEObject2) {
			throwRuleFailedException(ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(s) + " : " + "EClass" + " : " + "EObject",
				ECLASSEOBJECT2,
				e_applyRuleEClassEObject2);
			return null;
		}
	}
	
	protected Result2<EClass, EObject> applyRuleEClassEObject2(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final String s) 
			throws RuleFailedException {
		EClass _createEObject = null;
		
		String _string = new String();
		String _firstUpper = StringExtensions.toFirstUpper("bar");
		String _operator_plus = StringExtensions.operator_plus(_string, _firstUpper);
		boolean _operator_equals = ObjectExtensions.operator_equals("foo", _operator_plus);
		/* 'foo' == new String() + 'bar'.toFirstUpper */
		if (!_operator_equals) {
		  sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
		}
		EObject _createEObject_1 = EcoreFactory.eINSTANCE.createEObject();
		return new Result2<EClass, EObject>(_createEObject, _createEObject_1);
	}
	
	protected Result<List<EStructuralFeature>> featuresImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eclass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<List<EStructuralFeature>> _result_ = applyRuleFeatures(G, _subtrace_, eclass);
			addToTrace(_trace_, ruleName("Features") + stringRepForEnv(G) + " |- " + stringRep(eclass) + " >> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleFeatures) {
			throwRuleFailedException(ruleName("Features") + stringRepForEnv(G) + " |- " + stringRep(eclass) + " >> " + "List<EStructuralFeature>",
				FEATURES,
				e_applyRuleFeatures, new ErrorInformation(eclass));
			return null;
		}
	}
	
	protected Result<List<EStructuralFeature>> applyRuleFeatures(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eclass) 
			throws RuleFailedException {
		List<EStructuralFeature> features = null;
		
		/* G |- eclass >> features */
		Result<List<EStructuralFeature>> result = featuresInternal(G, _trace_, eclass);
		checkAssignableTo(result.getFirst(), List.class);
		features = (List<EStructuralFeature>) result.getFirst();
		
		return new Result<List<EStructuralFeature>>(features);
	}
	
	protected Result<Boolean> collectionsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eclass, final List<EStructuralFeature> features) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleColelctions(G, _subtrace_, eclass, features);
			addToTrace(_trace_, ruleName("Colelctions") + stringRepForEnv(G) + " |- " + stringRep(eclass) + " |> " + stringRep(features));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleColelctions) {
			throwRuleFailedException(ruleName("Colelctions") + stringRepForEnv(G) + " |- " + stringRep(eclass) + " |> " + stringRep(features),
				COLELCTIONS,
				e_applyRuleColelctions, new ErrorInformation(eclass));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleColelctions(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eclass, final List<EStructuralFeature> features) 
			throws RuleFailedException {
		
		/* G |- eclass |> features */
		collectionsInternal(G, _trace_, eclass, features);
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> type1Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EObject obj) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleForEach(G, _subtrace_, obj);
			addToTrace(_trace_, ruleName("ForEach") + stringRepForEnv(G) + " |- " + stringRep(obj));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleForEach) {
			throwRuleFailedException(ruleName("ForEach") + stringRepForEnv(G) + " |- " + stringRep(obj),
				FOREACH,
				e_applyRuleForEach, new ErrorInformation(obj));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleForEach(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EObject obj) 
			throws RuleFailedException {
		
		EClass _eClass = obj.eClass();
		EList<EStructuralFeature> _eStructuralFeatures = _eClass.getEStructuralFeatures();
		final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {
		    public void apply(final EStructuralFeature it) {
		      /* G |- it */
		      type1Internal(G, _trace_, it);
		    }
		  };
		IterableExtensions.<EStructuralFeature>forEach(_eStructuralFeatures, _function);
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> type1Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleForEachWithBooleanExpressionInside(G, _subtrace_, eClass);
			addToTrace(_trace_, ruleName("ForEachWithBooleanExpressionInside") + stringRepForEnv(G) + " |- " + stringRep(eClass));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleForEachWithBooleanExpressionInside) {
			throwRuleFailedException(ruleName("ForEachWithBooleanExpressionInside") + stringRepForEnv(G) + " |- " + stringRep(eClass),
				FOREACHWITHBOOLEANEXPRESSIONINSIDE,
				e_applyRuleForEachWithBooleanExpressionInside, new ErrorInformation(eClass));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleForEachWithBooleanExpressionInside(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		
		EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
		final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {
		    public void apply(final EStructuralFeature it) {
		      String _name = it.getName();
		      ObjectExtensions.operator_notEquals(_name, "foo");
		    }
		  };
		IterableExtensions.<EStructuralFeature>forEach(_eStructuralFeatures, _function);
		return new Result<Boolean>(true);
	}
	
	protected Result<EClass> withfailImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EObject o2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<EClass> _result_ = applyRuleWithFail(G, _subtrace_, o2);
			addToTrace(_trace_, ruleName("WithFail") + stringRepForEnv(G) + " |~ " + stringRep(o2) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleWithFail) {
			throwRuleFailedException(ruleName("WithFail") + stringRepForEnv(G) + " |~ " + stringRep(o2) + " : " + "EClass",
				WITHFAIL,
				e_applyRuleWithFail, new ErrorInformation(o2));
			return null;
		}
	}
	
	protected Result<EClass> applyRuleWithFail(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EObject o2) 
			throws RuleFailedException {
		EClass eClass = null;
		
		/* fail or fail error "this is an error" source o2.eClass feature o2.eClass.eContainingFeature */
		try {
		  /* fail */
		  throwForExplicitFail();
		} catch (Exception e) {
		  /* fail error "this is an error" source o2.eClass feature o2.eClass.eContainingFeature */
		  String error = "this is an error";
		  EClass _eClass = o2.eClass();
		  EObject source = _eClass;
		  EClass _eClass_1 = o2.eClass();
		  EStructuralFeature _eContainingFeature = _eClass_1.eContainingFeature();
		  EStructuralFeature feature = _eContainingFeature;
		  throwForExplicitFail(error, new ErrorInformation(source, feature));
		}
		return new Result<EClass>(eClass);
	}
	
	protected Result<Boolean> closuresImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleTestForClosures(G, _subtrace_, eClass);
			addToTrace(_trace_, ruleName("TestForClosures") + stringRepForEnv(G) + " ||~ " + stringRep(eClass));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTestForClosures) {
			throwRuleFailedException(ruleName("TestForClosures") + stringRepForEnv(G) + " ||~ " + stringRep(eClass),
				TESTFORCLOSURES,
				e_applyRuleTestForClosures, new ErrorInformation(eClass));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleTestForClosures(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		
		{
		  EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
		  final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
		      public Boolean apply(final EStructuralFeature it) {
		        String _name = it.getName();
		        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, "foo");
		        return Boolean.valueOf(_operator_notEquals);
		      }
		    };
		  boolean _forall = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures, _function);
		  /* eClass.EStructuralFeatures.forall [ it.name != 'foo' ] */
		  if (!_forall) {
		    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.forall [ it.name != \'foo\' ]");
		  }
		  EList<EStructuralFeature> _eStructuralFeatures_1 = eClass.getEStructuralFeatures();
		  EStructuralFeature _get = _eStructuralFeatures_1.get(0);
		  String _name = _get.getName();
		  boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, "foo");
		  /* eClass.EStructuralFeatures.get(0).name != 'foo' */
		  if (!_operator_notEquals) {
		    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.get(0).name != \'foo\'");
		  }
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> environmentsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleTestForEnvironments(G, _subtrace_, eClass);
			addToTrace(_trace_, ruleName("TestForEnvironments") + stringRepForEnv(G) + " ||- " + stringRep(eClass));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTestForEnvironments) {
			throwRuleFailedException(ruleName("TestForEnvironments") + stringRepForEnv(G) + " ||- " + stringRep(eClass),
				TESTFORENVIRONMENTS,
				e_applyRuleTestForEnvironments, new ErrorInformation(eClass));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleTestForEnvironments(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		
		/* 'this' <- eClass ||- eClass */
		environmentsInternal(environmentEntry("this", eClass), _trace_, eClass);
		return new Result<Boolean>(true);
	}
}
