package it.xsemantics.dsl.tests.inferrer.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.Map;
import junit.framework.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProviderForInferrer.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsJvmModelGeneratorTest extends XsemanticsBaseTest {
  @Inject
  protected JvmModelGenerator generator;
  
  private static String TEST_TYPESYSTEM_NAME = "it.xsemantics.test.TypeSystem";
  
  private static String OUTPUT_PREFIX = "DEFAULT_OUTPUT";
  
  @Test
  public void testJudgmentDescriptions() {
    CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testJudgmentDescriptions);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleApplicationTrace;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleEnvironment;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Set;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"typeImpl\", 4, \"|-\", \":\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final List<String> list, final Set<Integer> set) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(new RuleEnvironment(), null, list, set);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final RuleEnvironment _environment_, final List<String> list, final Set<Integer> set) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(_environment_, null, list, set);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeInternal(_environment_, _trace_, list, set);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(_e_type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(list, set);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeDispatcher.invoke(_environment_, _trace_, list, set);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  @Test
  public void testSimpleRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testSimpleRule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.google.common.base.Objects;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.ErrorInformation;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleApplicationTrace;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleEnvironment;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleFailedException;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EcoreFactory;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.StringExtensions;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"typeImpl\", 4, \"|-\", \":\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final EClass c, final EObject o) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(new RuleEnvironment(), null, c, o);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final RuleEnvironment _environment_, final EClass c, final EObject o) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(_environment_, null, c, o);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeInternal(_environment_, _trace_, c, o);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(_e_type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c, o);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeDispatcher.invoke(_environment_, _trace_, c, o);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("RuleApplicationTrace _subtrace_ = newTrace(_trace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addToTrace(_trace_, ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object));");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addAsSubtrace(_trace_, _subtrace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return _result_;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception e_applyRuleEClassEObject) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("throwRuleFailedException(ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object),");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("ECLASSEOBJECT,");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("e_applyRuleEClassEObject, new ErrorInformation(eClass), new ErrorInformation(object));");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("String _string = new String();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("String _firstUpper = StringExtensions.toFirstUpper(\"bar\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("String _plus = (_string + _firstUpper);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("boolean _equals = Objects.equal(\"foo\", _plus);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("/* \'foo\' == new String() + \"bar\".toFirstUpper */");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (!_equals) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("sneakyThrowRuleFailedException(\"\\\'foo\\\' == new String() + \\\"bar\\\".toFirstUpper\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("final EClass eC = EcoreFactory.eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("eC.setName(\"MyEClass\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("boolean _equals_1 = Objects.equal(eClass, eC);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("/* eClass == eC */");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (!Boolean.valueOf(_equals_1)) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("sneakyThrowRuleFailedException(\"eClass == eC\");");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result<Boolean>(true);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  @Test
  public void testRuleWithTwoOutputParams() {
    CharSequence _testRuleWithTwoOutputParams = this.testFiles.testRuleWithTwoOutputParams();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testRuleWithTwoOutputParams);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.ErrorInformation;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result2;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleApplicationTrace;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleEnvironment;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleFailedException;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EStructuralFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public final static String ECLASSEOBJECTESTRUCTURALFEATURE = \"it.xsemantics.test.rules.EClassEObjectEStructuralFeature\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<EObject>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> type2Dispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<EObject>> subtypeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"typeImpl\", 4, \"|-\", \":\", \":\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type2Dispatcher = buildPolymorphicDispatcher2(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"type2Impl\", 3, \"||-\", \":\", \":\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("subtypeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"subtypeImpl\", 4, \"||-\", \"<:\", \":>\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> type(final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(new RuleEnvironment(), null, c, f);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> type(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(_environment_, null, c, f);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeInternal(_environment_, _trace_, c, f);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(_e_type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result2<EObject,EStructuralFeature> type2(final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type2(new RuleEnvironment(), null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type2(_environment_, null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return type2Internal(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type2) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure2(_e_type2);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> subtype(final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return subtype(new RuleEnvironment(), null, c, f);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> subtype(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return subtype(_environment_, null, c, f);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EObject> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return subtypeInternal(_environment_, _trace_, c, f);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_subtype) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(_e_subtype);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c, f);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeDispatcher.invoke(_environment_, _trace_, c, f);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result2<EObject,EStructuralFeature> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return type2Dispatcher.invoke(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type2) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type2);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<EObject> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c, f);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return subtypeDispatcher.invoke(_environment_, _trace_, c, f);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_subtype) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_subtype);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result2<EObject,EStructuralFeature> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("RuleApplicationTrace _subtrace_ = newTrace(_trace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Result2<EObject,EStructuralFeature> _result_ = applyRuleEClassEObjectEStructuralFeature(G, _subtrace_, eClass);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addToTrace(_trace_, ruleName(\"EClassEObjectEStructuralFeature\") + stringRepForEnv(G) + \" ||- \" + stringRep(eClass) + \" : \" + stringRep(_result_.getFirst()) + \" : \" + stringRep(_result_.getSecond()));");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addAsSubtrace(_trace_, _subtrace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return _result_;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception e_applyRuleEClassEObjectEStructuralFeature) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("throwRuleFailedException(ruleName(\"EClassEObjectEStructuralFeature\") + stringRepForEnv(G) + \" ||- \" + stringRep(eClass) + \" : \" + \"EObject\" + \" : \" + \"EStructuralFeature\",");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("ECLASSEOBJECTESTRUCTURALFEATURE,");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("e_applyRuleEClassEObjectEStructuralFeature, new ErrorInformation(eClass));");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result2<EObject,EStructuralFeature> applyRuleEClassEObjectEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EObject object = null; // output parameter");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature feat = null; // output parameter");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* G ||- eClass : object : feat */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("checkAssignableTo(result.getSecond(), EStructuralFeature.class);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("feat = (EStructuralFeature) result.getSecond();");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result2<EObject,EStructuralFeature>(object, feat);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  @Test
  public void testJudgmentDescriptionsWithErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testJudgmentDescriptionsWithErrorSpecification);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.ErrorInformation;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleApplicationTrace;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleEnvironment;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.RuleFailedException;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EStructuralFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<EClass>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"typeImpl\", 3, \"|-\", \":\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EClass> type(final EObject c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(new RuleEnvironment(), null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(_environment_, null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeInternal(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(_e_type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeDispatcher.invoke(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected void typeThrowException(final String _issue, final Exception _ex, final EObject c) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _plus = (\"this \" + c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EObject source = c;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("_issue, _ex, new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  public InMemoryFileSystemAccess runGenerator(final CharSequence prog) {
    InMemoryFileSystemAccess _xblockexpression = null;
    {
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      final InMemoryFileSystemAccess fs = _inMemoryFileSystemAccess;
      Resource _loadResource = this.loadResource(prog);
      this.generator.doGenerate(_loadResource, fs);
      _xblockexpression = (fs);
    }
    return _xblockexpression;
  }
  
  public Resource loadResource(final CharSequence prog) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Resource _eResource = _parseAndAssertNoError.eResource();
    return _eResource;
  }
  
  public void assertGeneratedCode(final InMemoryFileSystemAccess fs, final String tsName, final CharSequence expected) {
    Map<String,CharSequence> _files = fs.getFiles();
    String _replace = tsName.replace(".", "/");
    String _plus = (XsemanticsJvmModelGeneratorTest.OUTPUT_PREFIX + _replace);
    String _plus_1 = (_plus + ".java");
    final CharSequence genCode = _files.get(_plus_1);
    Assert.assertNotNull(genCode);
    this.assertEqualsStrings(expected, genCode);
  }
}
