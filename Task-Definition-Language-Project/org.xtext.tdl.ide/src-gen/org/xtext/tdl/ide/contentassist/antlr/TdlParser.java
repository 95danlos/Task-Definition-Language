/*
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.xtext.tdl.ide.contentassist.antlr.internal.InternalTdlParser;
import org.xtext.tdl.services.TdlGrammarAccess;

public class TdlParser extends AbstractContentAssistParser {

	@Inject
	private TdlGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalTdlParser createParser() {
		InternalTdlParser result = new InternalTdlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new TdlTokenSource(super.createLexer(stream));
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getSimpleActionReferenceAccess().getAlternatives_1(), "rule__SimpleActionReference__Alternatives_1");
					put(grammarAccess.getSimpleActionReferenceAccess().getAlternatives_1_0_2(), "rule__SimpleActionReference__Alternatives_1_0_2");
					put(grammarAccess.getSimpleActionAccess().getAlternatives_2(), "rule__SimpleAction__Alternatives_2");
					put(grammarAccess.getRosNodeAccess().getAlternatives(), "rule__RosNode__Alternatives");
					put(grammarAccess.getCodeBlockAccess().getAlternatives(), "rule__CodeBlock__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getCompositeTaskAccess().getGroup(), "rule__CompositeTask__Group__0");
					put(grammarAccess.getTaskAccess().getGroup(), "rule__Task__Group__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup(), "rule__SimpleActionReference__Group__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0(), "rule__SimpleActionReference__Group_1_0__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0_1(), "rule__SimpleActionReference__Group_1_0_1__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0_1_0(), "rule__SimpleActionReference__Group_1_0_1_0__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0_1_1(), "rule__SimpleActionReference__Group_1_0_1_1__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0_1_2(), "rule__SimpleActionReference__Group_1_0_1_2__0");
					put(grammarAccess.getSimpleActionReferenceAccess().getGroup_1_0_1_3(), "rule__SimpleActionReference__Group_1_0_1_3__0");
					put(grammarAccess.getArgumentAccess().getGroup(), "rule__Argument__Group__0");
					put(grammarAccess.getRobotAccess().getGroup(), "rule__Robot__Group__0");
					put(grammarAccess.getInitializationModuleAccess().getGroup(), "rule__InitializationModule__Group__0");
					put(grammarAccess.getSimpleActionAccess().getGroup(), "rule__SimpleAction__Group__0");
					put(grammarAccess.getSimpleActionAccess().getGroup_2_0(), "rule__SimpleAction__Group_2_0__0");
					put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
					put(grammarAccess.getRosNodeAccess().getGroup_0(), "rule__RosNode__Group_0__0");
					put(grammarAccess.getRosNodeAccess().getGroup_1(), "rule__RosNode__Group_1__0");
					put(grammarAccess.getRosNodeAccess().getGroup_1_6(), "rule__RosNode__Group_1_6__0");
					put(grammarAccess.getRosNodeAccess().getGroup_1_8(), "rule__RosNode__Group_1_8__0");
					put(grammarAccess.getParameterListAccess().getGroup(), "rule__ParameterList__Group__0");
					put(grammarAccess.getPublishedDataAccess().getGroup(), "rule__PublishedData__Group__0");
					put(grammarAccess.getTopicAccess().getGroup(), "rule__Topic__Group__0");
					put(grammarAccess.getCodeBlock_2Access().getGroup(), "rule__CodeBlock_2__Group__0");
					put(grammarAccess.getModelAccess().getCompositeTasksAssignment_0(), "rule__Model__CompositeTasksAssignment_0");
					put(grammarAccess.getModelAccess().getRobotsAssignment_1(), "rule__Model__RobotsAssignment_1");
					put(grammarAccess.getCompositeTaskAccess().getNameAssignment_1(), "rule__CompositeTask__NameAssignment_1");
					put(grammarAccess.getCompositeTaskAccess().getTasksAssignment_4(), "rule__CompositeTask__TasksAssignment_4");
					put(grammarAccess.getTaskAccess().getNameAssignment_1(), "rule__Task__NameAssignment_1");
					put(grammarAccess.getTaskAccess().getSimpleActionsAssignment_4(), "rule__Task__SimpleActionsAssignment_4");
					put(grammarAccess.getSimpleActionReferenceAccess().getNameAssignment_0(), "rule__SimpleActionReference__NameAssignment_0");
					put(grammarAccess.getSimpleActionReferenceAccess().getIdAssignment_1_0_1_0_1(), "rule__SimpleActionReference__IdAssignment_1_0_1_0_1");
					put(grammarAccess.getSimpleActionReferenceAccess().getSyncAssignment_1_0_1_1_1(), "rule__SimpleActionReference__SyncAssignment_1_0_1_1_1");
					put(grammarAccess.getSimpleActionReferenceAccess().getAfterAssignment_1_0_1_2_1(), "rule__SimpleActionReference__AfterAssignment_1_0_1_2_1");
					put(grammarAccess.getSimpleActionReferenceAccess().getArgumentsAssignment_1_0_1_3_1(), "rule__SimpleActionReference__ArgumentsAssignment_1_0_1_3_1");
					put(grammarAccess.getSimpleActionReferenceAccess().getPositionalAssignment_1_1(), "rule__SimpleActionReference__PositionalAssignment_1_1");
					put(grammarAccess.getArgumentAccess().getNameAssignment_0(), "rule__Argument__NameAssignment_0");
					put(grammarAccess.getRobotAccess().getNameAssignment_1(), "rule__Robot__NameAssignment_1");
					put(grammarAccess.getRobotAccess().getPublishedDataAssignment_4(), "rule__Robot__PublishedDataAssignment_4");
					put(grammarAccess.getRobotAccess().getInitializationModuleAssignment_5(), "rule__Robot__InitializationModuleAssignment_5");
					put(grammarAccess.getRobotAccess().getSimpleActionsAssignment_6(), "rule__Robot__SimpleActionsAssignment_6");
					put(grammarAccess.getRobotAccess().getRosNodesAssignment_7(), "rule__Robot__RosNodesAssignment_7");
					put(grammarAccess.getInitializationModuleAccess().getCodeBlockAssignment_2(), "rule__InitializationModule__CodeBlockAssignment_2");
					put(grammarAccess.getSimpleActionAccess().getNameAssignment_1(), "rule__SimpleAction__NameAssignment_1");
					put(grammarAccess.getSimpleActionAccess().getParametersAssignment_2_0_1(), "rule__SimpleAction__ParametersAssignment_2_0_1");
					put(grammarAccess.getSimpleActionAccess().getPositionalAssignment_2_1(), "rule__SimpleAction__PositionalAssignment_2_1");
					put(grammarAccess.getSimpleActionAccess().getCodeBlockAssignment_4(), "rule__SimpleAction__CodeBlockAssignment_4");
					put(grammarAccess.getParameterAccess().getNameAssignment_0(), "rule__Parameter__NameAssignment_0");
					put(grammarAccess.getRosNodeAccess().getNameAssignment_0_1(), "rule__RosNode__NameAssignment_0_1");
					put(grammarAccess.getRosNodeAccess().getCodeBlockAssignment_0_4(), "rule__RosNode__CodeBlockAssignment_0_4");
					put(grammarAccess.getRosNodeAccess().getNameAssignment_1_1(), "rule__RosNode__NameAssignment_1_1");
					put(grammarAccess.getRosNodeAccess().getNodeTypeAssignment_1_3(), "rule__RosNode__NodeTypeAssignment_1_3");
					put(grammarAccess.getRosNodeAccess().getNodeNameAssignment_1_5(), "rule__RosNode__NodeNameAssignment_1_5");
					put(grammarAccess.getRosNodeAccess().getNodeArgsAssignment_1_6_1(), "rule__RosNode__NodeArgsAssignment_1_6_1");
					put(grammarAccess.getRosNodeAccess().getParameterListAssignment_1_8_1(), "rule__RosNode__ParameterListAssignment_1_8_1");
					put(grammarAccess.getParameterListAccess().getCodeBlockAssignment_2(), "rule__ParameterList__CodeBlockAssignment_2");
					put(grammarAccess.getPublishedDataAccess().getTopicsAssignment_2(), "rule__PublishedData__TopicsAssignment_2");
					put(grammarAccess.getTopicAccess().getNameAssignment_0(), "rule__Topic__NameAssignment_0");
					put(grammarAccess.getTopicAccess().getTopicAssignment_2(), "rule__Topic__TopicAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TdlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TdlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
