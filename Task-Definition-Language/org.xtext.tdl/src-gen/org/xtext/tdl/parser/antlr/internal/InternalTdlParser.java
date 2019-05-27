package org.xtext.tdl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.tdl.services.TdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTdlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PublishedData", "CompositeTask", "SimpleAction", "Parameters", "LatLng", "RosNode", "After", "Args", "Setup", "Robot", "Sync", "Task", "LeftParenthesisRightParenthesisColon", "RightParenthesisRightParenthesisColon", "Id", "LeftParenthesisRightParenthesis", "RightParenthesisRightParenthesis", "RightParenthesisColon", "Apostrophe", "LeftParenthesis", "RightParenthesis", "Comma", "Colon", "RULE_BEGIN", "RULE_END", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Task=15;
    public static final int RULE_END=28;
    public static final int RULE_BEGIN=27;
    public static final int RULE_STRING=31;
    public static final int RULE_SL_COMMENT=33;
    public static final int Comma=25;
    public static final int LeftParenthesisRightParenthesis=19;
    public static final int LeftParenthesis=23;
    public static final int RightParenthesisRightParenthesisColon=17;
    public static final int LatLng=8;
    public static final int Colon=26;
    public static final int Setup=12;
    public static final int Sync=14;
    public static final int EOF=-1;
    public static final int Apostrophe=22;
    public static final int RightParenthesisColon=21;
    public static final int Args=11;
    public static final int Parameters=7;
    public static final int RULE_ID=29;
    public static final int RULE_WS=34;
    public static final int RightParenthesis=24;
    public static final int RULE_ANY_OTHER=35;
    public static final int SimpleAction=6;
    public static final int CompositeTask=5;
    public static final int RightParenthesisRightParenthesis=20;
    public static final int LeftParenthesisRightParenthesisColon=16;
    public static final int RULE_INT=30;
    public static final int After=10;
    public static final int RULE_ML_COMMENT=32;
    public static final int RosNode=9;
    public static final int Id=18;
    public static final int Robot=13;
    public static final int PublishedData=4;

    // delegates
    // delegators


        public InternalTdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTdlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTdlParser.g"; }



     	private TdlGrammarAccess grammarAccess;

        public InternalTdlParser(TokenStream input, TdlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected TdlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalTdlParser.g:57:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTdlParser.g:57:46: (iv_ruleModel= ruleModel EOF )
            // InternalTdlParser.g:58:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalTdlParser.g:64:1: ruleModel returns [EObject current=null] : ( ( (lv_compositeTasks_0_0= ruleCompositeTask ) )* ( (lv_robots_1_0= ruleRobot ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_compositeTasks_0_0 = null;

        EObject lv_robots_1_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:70:2: ( ( ( (lv_compositeTasks_0_0= ruleCompositeTask ) )* ( (lv_robots_1_0= ruleRobot ) )* ) )
            // InternalTdlParser.g:71:2: ( ( (lv_compositeTasks_0_0= ruleCompositeTask ) )* ( (lv_robots_1_0= ruleRobot ) )* )
            {
            // InternalTdlParser.g:71:2: ( ( (lv_compositeTasks_0_0= ruleCompositeTask ) )* ( (lv_robots_1_0= ruleRobot ) )* )
            // InternalTdlParser.g:72:3: ( (lv_compositeTasks_0_0= ruleCompositeTask ) )* ( (lv_robots_1_0= ruleRobot ) )*
            {
            // InternalTdlParser.g:72:3: ( (lv_compositeTasks_0_0= ruleCompositeTask ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==CompositeTask) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTdlParser.g:73:4: (lv_compositeTasks_0_0= ruleCompositeTask )
            	    {
            	    // InternalTdlParser.g:73:4: (lv_compositeTasks_0_0= ruleCompositeTask )
            	    // InternalTdlParser.g:74:5: lv_compositeTasks_0_0= ruleCompositeTask
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getCompositeTasksCompositeTaskParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_compositeTasks_0_0=ruleCompositeTask();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"compositeTasks",
            	    						lv_compositeTasks_0_0,
            	    						"org.xtext.tdl.Tdl.CompositeTask");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalTdlParser.g:91:3: ( (lv_robots_1_0= ruleRobot ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Robot) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTdlParser.g:92:4: (lv_robots_1_0= ruleRobot )
            	    {
            	    // InternalTdlParser.g:92:4: (lv_robots_1_0= ruleRobot )
            	    // InternalTdlParser.g:93:5: lv_robots_1_0= ruleRobot
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getRobotsRobotParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_robots_1_0=ruleRobot();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"robots",
            	    						lv_robots_1_0,
            	    						"org.xtext.tdl.Tdl.Robot");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCompositeTask"
    // InternalTdlParser.g:114:1: entryRuleCompositeTask returns [EObject current=null] : iv_ruleCompositeTask= ruleCompositeTask EOF ;
    public final EObject entryRuleCompositeTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeTask = null;


        try {
            // InternalTdlParser.g:114:54: (iv_ruleCompositeTask= ruleCompositeTask EOF )
            // InternalTdlParser.g:115:2: iv_ruleCompositeTask= ruleCompositeTask EOF
            {
             newCompositeNode(grammarAccess.getCompositeTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompositeTask=ruleCompositeTask();

            state._fsp--;

             current =iv_ruleCompositeTask; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeTask"


    // $ANTLR start "ruleCompositeTask"
    // InternalTdlParser.g:121:1: ruleCompositeTask returns [EObject current=null] : (otherlv_0= CompositeTask ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LatLng this_BEGIN_3= RULE_BEGIN ( (lv_tasks_4_0= ruleTask ) )* this_END_5= RULE_END ) ;
    public final EObject ruleCompositeTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        EObject lv_tasks_4_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:127:2: ( (otherlv_0= CompositeTask ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LatLng this_BEGIN_3= RULE_BEGIN ( (lv_tasks_4_0= ruleTask ) )* this_END_5= RULE_END ) )
            // InternalTdlParser.g:128:2: (otherlv_0= CompositeTask ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LatLng this_BEGIN_3= RULE_BEGIN ( (lv_tasks_4_0= ruleTask ) )* this_END_5= RULE_END )
            {
            // InternalTdlParser.g:128:2: (otherlv_0= CompositeTask ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LatLng this_BEGIN_3= RULE_BEGIN ( (lv_tasks_4_0= ruleTask ) )* this_END_5= RULE_END )
            // InternalTdlParser.g:129:3: otherlv_0= CompositeTask ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LatLng this_BEGIN_3= RULE_BEGIN ( (lv_tasks_4_0= ruleTask ) )* this_END_5= RULE_END
            {
            otherlv_0=(Token)match(input,CompositeTask,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getCompositeTaskAccess().getCompositeTaskKeyword_0());
            		
            // InternalTdlParser.g:133:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTdlParser.g:134:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTdlParser.g:134:4: (lv_name_1_0= RULE_ID )
            // InternalTdlParser.g:135:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCompositeTaskAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompositeTaskRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,LatLng,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeTaskAccess().getLatLngKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getCompositeTaskAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalTdlParser.g:159:3: ( (lv_tasks_4_0= ruleTask ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Task) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTdlParser.g:160:4: (lv_tasks_4_0= ruleTask )
            	    {
            	    // InternalTdlParser.g:160:4: (lv_tasks_4_0= ruleTask )
            	    // InternalTdlParser.g:161:5: lv_tasks_4_0= ruleTask
            	    {

            	    					newCompositeNode(grammarAccess.getCompositeTaskAccess().getTasksTaskParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_tasks_4_0=ruleTask();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCompositeTaskRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tasks",
            	    						lv_tasks_4_0,
            	    						"org.xtext.tdl.Tdl.Task");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_5, grammarAccess.getCompositeTaskAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompositeTask"


    // $ANTLR start "entryRuleTask"
    // InternalTdlParser.g:186:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalTdlParser.g:186:45: (iv_ruleTask= ruleTask EOF )
            // InternalTdlParser.g:187:2: iv_ruleTask= ruleTask EOF
            {
             newCompositeNode(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTask=ruleTask();

            state._fsp--;

             current =iv_ruleTask; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalTdlParser.g:193:1: ruleTask returns [EObject current=null] : (otherlv_0= Task ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )* this_END_5= RULE_END ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        EObject lv_simpleActions_4_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:199:2: ( (otherlv_0= Task ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )* this_END_5= RULE_END ) )
            // InternalTdlParser.g:200:2: (otherlv_0= Task ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )* this_END_5= RULE_END )
            {
            // InternalTdlParser.g:200:2: (otherlv_0= Task ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )* this_END_5= RULE_END )
            // InternalTdlParser.g:201:3: otherlv_0= Task ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )* this_END_5= RULE_END
            {
            otherlv_0=(Token)match(input,Task,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTaskAccess().getTaskKeyword_0());
            		
            // InternalTdlParser.g:205:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTdlParser.g:206:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTdlParser.g:206:4: (lv_name_1_0= RULE_ID )
            // InternalTdlParser.g:207:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTaskAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTaskRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesisRightParenthesisColon,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getLeftParenthesisRightParenthesisColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_10); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getTaskAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalTdlParser.g:231:3: ( (lv_simpleActions_4_0= ruleSimpleActionReference ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTdlParser.g:232:4: (lv_simpleActions_4_0= ruleSimpleActionReference )
            	    {
            	    // InternalTdlParser.g:232:4: (lv_simpleActions_4_0= ruleSimpleActionReference )
            	    // InternalTdlParser.g:233:5: lv_simpleActions_4_0= ruleSimpleActionReference
            	    {

            	    					newCompositeNode(grammarAccess.getTaskAccess().getSimpleActionsSimpleActionReferenceParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_simpleActions_4_0=ruleSimpleActionReference();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTaskRule());
            	    					}
            	    					add(
            	    						current,
            	    						"simpleActions",
            	    						lv_simpleActions_4_0,
            	    						"org.xtext.tdl.Tdl.SimpleActionReference");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_5, grammarAccess.getTaskAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleSimpleActionReference"
    // InternalTdlParser.g:258:1: entryRuleSimpleActionReference returns [EObject current=null] : iv_ruleSimpleActionReference= ruleSimpleActionReference EOF ;
    public final EObject entryRuleSimpleActionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleActionReference = null;


        try {
            // InternalTdlParser.g:258:62: (iv_ruleSimpleActionReference= ruleSimpleActionReference EOF )
            // InternalTdlParser.g:259:2: iv_ruleSimpleActionReference= ruleSimpleActionReference EOF
            {
             newCompositeNode(grammarAccess.getSimpleActionReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleActionReference=ruleSimpleActionReference();

            state._fsp--;

             current =iv_ruleSimpleActionReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleActionReference"


    // $ANTLR start "ruleSimpleActionReference"
    // InternalTdlParser.g:265:1: ruleSimpleActionReference returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon ) ) ;
    public final EObject ruleSimpleActionReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_sync_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_after_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_positional_19_0=null;
        Token otherlv_20=null;
        EObject lv_arguments_14_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:271:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon ) ) )
            // InternalTdlParser.g:272:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon ) )
            {
            // InternalTdlParser.g:272:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon ) )
            // InternalTdlParser.g:273:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon )
            {
            // InternalTdlParser.g:273:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTdlParser.g:274:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTdlParser.g:274:4: (lv_name_0_0= RULE_ID )
            // InternalTdlParser.g:275:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_0_0, grammarAccess.getSimpleActionReferenceAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleActionReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTdlParser.g:291:3: ( (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) ) | ( (lv_positional_19_0= LatLng ) ) | otherlv_20= LeftParenthesisRightParenthesisColon )
            int alt18=3;
            switch ( input.LA(1) ) {
            case LeftParenthesis:
                {
                alt18=1;
                }
                break;
            case LatLng:
                {
                alt18=2;
                }
                break;
            case LeftParenthesisRightParenthesisColon:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalTdlParser.g:292:4: (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) )
                    {
                    // InternalTdlParser.g:292:4: (otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon ) )
                    // InternalTdlParser.g:293:5: otherlv_1= LeftParenthesis ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? ) (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon )
                    {
                    otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_12); 

                    					newLeafNode(otherlv_1, grammarAccess.getSimpleActionReferenceAccess().getLeftParenthesisKeyword_1_0_0());
                    				
                    // InternalTdlParser.g:297:5: ( (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )? )
                    // InternalTdlParser.g:298:6: (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )? (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )? (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )? (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )?
                    {
                    // InternalTdlParser.g:298:6: (otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )? )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Id) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalTdlParser.g:299:7: otherlv_2= Id ( (lv_id_3_0= RULE_STRING ) ) (otherlv_4= Comma )?
                            {
                            otherlv_2=(Token)match(input,Id,FOLLOW_13); 

                            							newLeafNode(otherlv_2, grammarAccess.getSimpleActionReferenceAccess().getIdKeyword_1_0_1_0_0());
                            						
                            // InternalTdlParser.g:303:7: ( (lv_id_3_0= RULE_STRING ) )
                            // InternalTdlParser.g:304:8: (lv_id_3_0= RULE_STRING )
                            {
                            // InternalTdlParser.g:304:8: (lv_id_3_0= RULE_STRING )
                            // InternalTdlParser.g:305:9: lv_id_3_0= RULE_STRING
                            {
                            lv_id_3_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

                            									newLeafNode(lv_id_3_0, grammarAccess.getSimpleActionReferenceAccess().getIdSTRINGTerminalRuleCall_1_0_1_0_1_0());
                            								

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getSimpleActionReferenceRule());
                            									}
                            									setWithLastConsumed(
                            										current,
                            										"id",
                            										lv_id_3_0,
                            										"org.eclipse.xtext.common.Terminals.STRING");
                            								

                            }


                            }

                            // InternalTdlParser.g:321:7: (otherlv_4= Comma )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==Comma) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalTdlParser.g:322:8: otherlv_4= Comma
                                    {
                                    otherlv_4=(Token)match(input,Comma,FOLLOW_15); 

                                    								newLeafNode(otherlv_4, grammarAccess.getSimpleActionReferenceAccess().getCommaKeyword_1_0_1_0_2());
                                    							

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // InternalTdlParser.g:328:6: (otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )? )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==Sync) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalTdlParser.g:329:7: otherlv_5= Sync ( (lv_sync_6_0= RULE_INT ) ) (otherlv_7= RightParenthesis )? (otherlv_8= Comma )?
                            {
                            otherlv_5=(Token)match(input,Sync,FOLLOW_16); 

                            							newLeafNode(otherlv_5, grammarAccess.getSimpleActionReferenceAccess().getSyncKeyword_1_0_1_1_0());
                            						
                            // InternalTdlParser.g:333:7: ( (lv_sync_6_0= RULE_INT ) )
                            // InternalTdlParser.g:334:8: (lv_sync_6_0= RULE_INT )
                            {
                            // InternalTdlParser.g:334:8: (lv_sync_6_0= RULE_INT )
                            // InternalTdlParser.g:335:9: lv_sync_6_0= RULE_INT
                            {
                            lv_sync_6_0=(Token)match(input,RULE_INT,FOLLOW_17); 

                            									newLeafNode(lv_sync_6_0, grammarAccess.getSimpleActionReferenceAccess().getSyncINTTerminalRuleCall_1_0_1_1_1_0());
                            								

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getSimpleActionReferenceRule());
                            									}
                            									setWithLastConsumed(
                            										current,
                            										"sync",
                            										lv_sync_6_0,
                            										"org.eclipse.xtext.common.Terminals.INT");
                            								

                            }


                            }

                            // InternalTdlParser.g:351:7: (otherlv_7= RightParenthesis )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==RightParenthesis) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalTdlParser.g:352:8: otherlv_7= RightParenthesis
                                    {
                                    otherlv_7=(Token)match(input,RightParenthesis,FOLLOW_18); 

                                    								newLeafNode(otherlv_7, grammarAccess.getSimpleActionReferenceAccess().getRightParenthesisKeyword_1_0_1_1_2());
                                    							

                                    }
                                    break;

                            }

                            // InternalTdlParser.g:357:7: (otherlv_8= Comma )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==Comma) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // InternalTdlParser.g:358:8: otherlv_8= Comma
                                    {
                                    otherlv_8=(Token)match(input,Comma,FOLLOW_19); 

                                    								newLeafNode(otherlv_8, grammarAccess.getSimpleActionReferenceAccess().getCommaKeyword_1_0_1_1_3());
                                    							

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // InternalTdlParser.g:364:6: (otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )? )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==After) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalTdlParser.g:365:7: otherlv_9= After ( (lv_after_10_0= RULE_STRING ) ) (otherlv_11= RightParenthesis )? (otherlv_12= Comma )?
                            {
                            otherlv_9=(Token)match(input,After,FOLLOW_13); 

                            							newLeafNode(otherlv_9, grammarAccess.getSimpleActionReferenceAccess().getAfterKeyword_1_0_1_2_0());
                            						
                            // InternalTdlParser.g:369:7: ( (lv_after_10_0= RULE_STRING ) )
                            // InternalTdlParser.g:370:8: (lv_after_10_0= RULE_STRING )
                            {
                            // InternalTdlParser.g:370:8: (lv_after_10_0= RULE_STRING )
                            // InternalTdlParser.g:371:9: lv_after_10_0= RULE_STRING
                            {
                            lv_after_10_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

                            									newLeafNode(lv_after_10_0, grammarAccess.getSimpleActionReferenceAccess().getAfterSTRINGTerminalRuleCall_1_0_1_2_1_0());
                            								

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getSimpleActionReferenceRule());
                            									}
                            									setWithLastConsumed(
                            										current,
                            										"after",
                            										lv_after_10_0,
                            										"org.eclipse.xtext.common.Terminals.STRING");
                            								

                            }


                            }

                            // InternalTdlParser.g:387:7: (otherlv_11= RightParenthesis )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0==RightParenthesis) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // InternalTdlParser.g:388:8: otherlv_11= RightParenthesis
                                    {
                                    otherlv_11=(Token)match(input,RightParenthesis,FOLLOW_21); 

                                    								newLeafNode(otherlv_11, grammarAccess.getSimpleActionReferenceAccess().getRightParenthesisKeyword_1_0_1_2_2());
                                    							

                                    }
                                    break;

                            }

                            // InternalTdlParser.g:393:7: (otherlv_12= Comma )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==Comma) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // InternalTdlParser.g:394:8: otherlv_12= Comma
                                    {
                                    otherlv_12=(Token)match(input,Comma,FOLLOW_22); 

                                    								newLeafNode(otherlv_12, grammarAccess.getSimpleActionReferenceAccess().getCommaKeyword_1_0_1_2_3());
                                    							

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // InternalTdlParser.g:400:6: (otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )? )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Args) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalTdlParser.g:401:7: otherlv_13= Args ( (lv_arguments_14_0= ruleArgument ) )* (otherlv_15= RightParenthesis )? (otherlv_16= Comma )?
                            {
                            otherlv_13=(Token)match(input,Args,FOLLOW_23); 

                            							newLeafNode(otherlv_13, grammarAccess.getSimpleActionReferenceAccess().getArgsKeyword_1_0_1_3_0());
                            						
                            // InternalTdlParser.g:405:7: ( (lv_arguments_14_0= ruleArgument ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_STRING) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalTdlParser.g:406:8: (lv_arguments_14_0= ruleArgument )
                            	    {
                            	    // InternalTdlParser.g:406:8: (lv_arguments_14_0= ruleArgument )
                            	    // InternalTdlParser.g:407:9: lv_arguments_14_0= ruleArgument
                            	    {

                            	    									newCompositeNode(grammarAccess.getSimpleActionReferenceAccess().getArgumentsArgumentParserRuleCall_1_0_1_3_1_0());
                            	    								
                            	    pushFollow(FOLLOW_23);
                            	    lv_arguments_14_0=ruleArgument();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getSimpleActionReferenceRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"arguments",
                            	    										lv_arguments_14_0,
                            	    										"org.xtext.tdl.Tdl.Argument");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            // InternalTdlParser.g:424:7: (otherlv_15= RightParenthesis )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( (LA14_0==RightParenthesis) ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // InternalTdlParser.g:425:8: otherlv_15= RightParenthesis
                                    {
                                    otherlv_15=(Token)match(input,RightParenthesis,FOLLOW_24); 

                                    								newLeafNode(otherlv_15, grammarAccess.getSimpleActionReferenceAccess().getRightParenthesisKeyword_1_0_1_3_2());
                                    							

                                    }
                                    break;

                            }

                            // InternalTdlParser.g:430:7: (otherlv_16= Comma )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==Comma) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // InternalTdlParser.g:431:8: otherlv_16= Comma
                                    {
                                    otherlv_16=(Token)match(input,Comma,FOLLOW_25); 

                                    								newLeafNode(otherlv_16, grammarAccess.getSimpleActionReferenceAccess().getCommaKeyword_1_0_1_3_3());
                                    							

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }

                    // InternalTdlParser.g:438:5: (otherlv_17= RightParenthesisColon | otherlv_18= RightParenthesisRightParenthesisColon )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RightParenthesisColon) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RightParenthesisRightParenthesisColon) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalTdlParser.g:439:6: otherlv_17= RightParenthesisColon
                            {
                            otherlv_17=(Token)match(input,RightParenthesisColon,FOLLOW_2); 

                            						newLeafNode(otherlv_17, grammarAccess.getSimpleActionReferenceAccess().getRightParenthesisColonKeyword_1_0_2_0());
                            					

                            }
                            break;
                        case 2 :
                            // InternalTdlParser.g:444:6: otherlv_18= RightParenthesisRightParenthesisColon
                            {
                            otherlv_18=(Token)match(input,RightParenthesisRightParenthesisColon,FOLLOW_2); 

                            						newLeafNode(otherlv_18, grammarAccess.getSimpleActionReferenceAccess().getRightParenthesisRightParenthesisColonKeyword_1_0_2_1());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTdlParser.g:451:4: ( (lv_positional_19_0= LatLng ) )
                    {
                    // InternalTdlParser.g:451:4: ( (lv_positional_19_0= LatLng ) )
                    // InternalTdlParser.g:452:5: (lv_positional_19_0= LatLng )
                    {
                    // InternalTdlParser.g:452:5: (lv_positional_19_0= LatLng )
                    // InternalTdlParser.g:453:6: lv_positional_19_0= LatLng
                    {
                    lv_positional_19_0=(Token)match(input,LatLng,FOLLOW_2); 

                    						newLeafNode(lv_positional_19_0, grammarAccess.getSimpleActionReferenceAccess().getPositionalLatLngKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleActionReferenceRule());
                    						}
                    						setWithLastConsumed(current, "positional", lv_positional_19_0, "(lat,lng):");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTdlParser.g:466:4: otherlv_20= LeftParenthesisRightParenthesisColon
                    {
                    otherlv_20=(Token)match(input,LeftParenthesisRightParenthesisColon,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getSimpleActionReferenceAccess().getLeftParenthesisRightParenthesisColonKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleActionReference"


    // $ANTLR start "entryRuleArgument"
    // InternalTdlParser.g:475:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalTdlParser.g:475:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalTdlParser.g:476:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalTdlParser.g:482:1: ruleArgument returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= Comma )? ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTdlParser.g:488:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= Comma )? ) )
            // InternalTdlParser.g:489:2: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= Comma )? )
            {
            // InternalTdlParser.g:489:2: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= Comma )? )
            // InternalTdlParser.g:490:3: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= Comma )?
            {
            // InternalTdlParser.g:490:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalTdlParser.g:491:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalTdlParser.g:491:4: (lv_name_0_0= RULE_STRING )
            // InternalTdlParser.g:492:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_name_0_0, grammarAccess.getArgumentAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArgumentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTdlParser.g:508:3: (otherlv_1= Comma )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Comma) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTdlParser.g:509:4: otherlv_1= Comma
                    {
                    otherlv_1=(Token)match(input,Comma,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getArgumentAccess().getCommaKeyword_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleRobot"
    // InternalTdlParser.g:518:1: entryRuleRobot returns [EObject current=null] : iv_ruleRobot= ruleRobot EOF ;
    public final EObject entryRuleRobot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobot = null;


        try {
            // InternalTdlParser.g:518:46: (iv_ruleRobot= ruleRobot EOF )
            // InternalTdlParser.g:519:2: iv_ruleRobot= ruleRobot EOF
            {
             newCompositeNode(grammarAccess.getRobotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobot=ruleRobot();

            state._fsp--;

             current =iv_ruleRobot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRobot"


    // $ANTLR start "ruleRobot"
    // InternalTdlParser.g:525:1: ruleRobot returns [EObject current=null] : (otherlv_0= Robot ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_publishedData_4_0= rulePublishedData ) )? ( (lv_initializationModule_5_0= ruleInitializationModule ) )? ( (lv_simpleActions_6_0= ruleSimpleAction ) )* ( (lv_rosNodes_7_0= ruleRosNode ) )* this_END_8= RULE_END ) ;
    public final EObject ruleRobot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_8=null;
        EObject lv_publishedData_4_0 = null;

        EObject lv_initializationModule_5_0 = null;

        EObject lv_simpleActions_6_0 = null;

        EObject lv_rosNodes_7_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:531:2: ( (otherlv_0= Robot ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_publishedData_4_0= rulePublishedData ) )? ( (lv_initializationModule_5_0= ruleInitializationModule ) )? ( (lv_simpleActions_6_0= ruleSimpleAction ) )* ( (lv_rosNodes_7_0= ruleRosNode ) )* this_END_8= RULE_END ) )
            // InternalTdlParser.g:532:2: (otherlv_0= Robot ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_publishedData_4_0= rulePublishedData ) )? ( (lv_initializationModule_5_0= ruleInitializationModule ) )? ( (lv_simpleActions_6_0= ruleSimpleAction ) )* ( (lv_rosNodes_7_0= ruleRosNode ) )* this_END_8= RULE_END )
            {
            // InternalTdlParser.g:532:2: (otherlv_0= Robot ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_publishedData_4_0= rulePublishedData ) )? ( (lv_initializationModule_5_0= ruleInitializationModule ) )? ( (lv_simpleActions_6_0= ruleSimpleAction ) )* ( (lv_rosNodes_7_0= ruleRosNode ) )* this_END_8= RULE_END )
            // InternalTdlParser.g:533:3: otherlv_0= Robot ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_publishedData_4_0= rulePublishedData ) )? ( (lv_initializationModule_5_0= ruleInitializationModule ) )? ( (lv_simpleActions_6_0= ruleSimpleAction ) )* ( (lv_rosNodes_7_0= ruleRosNode ) )* this_END_8= RULE_END
            {
            otherlv_0=(Token)match(input,Robot,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRobotAccess().getRobotKeyword_0());
            		
            // InternalTdlParser.g:537:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTdlParser.g:538:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTdlParser.g:538:4: (lv_name_1_0= RULE_ID )
            // InternalTdlParser.g:539:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRobotAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getRobotAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_28); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getRobotAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalTdlParser.g:563:3: ( (lv_publishedData_4_0= rulePublishedData ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==PublishedData) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTdlParser.g:564:4: (lv_publishedData_4_0= rulePublishedData )
                    {
                    // InternalTdlParser.g:564:4: (lv_publishedData_4_0= rulePublishedData )
                    // InternalTdlParser.g:565:5: lv_publishedData_4_0= rulePublishedData
                    {

                    					newCompositeNode(grammarAccess.getRobotAccess().getPublishedDataPublishedDataParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_29);
                    lv_publishedData_4_0=rulePublishedData();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRobotRule());
                    					}
                    					set(
                    						current,
                    						"publishedData",
                    						lv_publishedData_4_0,
                    						"org.xtext.tdl.Tdl.PublishedData");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTdlParser.g:582:3: ( (lv_initializationModule_5_0= ruleInitializationModule ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Setup) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTdlParser.g:583:4: (lv_initializationModule_5_0= ruleInitializationModule )
                    {
                    // InternalTdlParser.g:583:4: (lv_initializationModule_5_0= ruleInitializationModule )
                    // InternalTdlParser.g:584:5: lv_initializationModule_5_0= ruleInitializationModule
                    {

                    					newCompositeNode(grammarAccess.getRobotAccess().getInitializationModuleInitializationModuleParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_30);
                    lv_initializationModule_5_0=ruleInitializationModule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRobotRule());
                    					}
                    					set(
                    						current,
                    						"initializationModule",
                    						lv_initializationModule_5_0,
                    						"org.xtext.tdl.Tdl.InitializationModule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTdlParser.g:601:3: ( (lv_simpleActions_6_0= ruleSimpleAction ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==SimpleAction) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalTdlParser.g:602:4: (lv_simpleActions_6_0= ruleSimpleAction )
            	    {
            	    // InternalTdlParser.g:602:4: (lv_simpleActions_6_0= ruleSimpleAction )
            	    // InternalTdlParser.g:603:5: lv_simpleActions_6_0= ruleSimpleAction
            	    {

            	    					newCompositeNode(grammarAccess.getRobotAccess().getSimpleActionsSimpleActionParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_simpleActions_6_0=ruleSimpleAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRobotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"simpleActions",
            	    						lv_simpleActions_6_0,
            	    						"org.xtext.tdl.Tdl.SimpleAction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalTdlParser.g:620:3: ( (lv_rosNodes_7_0= ruleRosNode ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RosNode) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalTdlParser.g:621:4: (lv_rosNodes_7_0= ruleRosNode )
            	    {
            	    // InternalTdlParser.g:621:4: (lv_rosNodes_7_0= ruleRosNode )
            	    // InternalTdlParser.g:622:5: lv_rosNodes_7_0= ruleRosNode
            	    {

            	    					newCompositeNode(grammarAccess.getRobotAccess().getRosNodesRosNodeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_rosNodes_7_0=ruleRosNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRobotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rosNodes",
            	    						lv_rosNodes_7_0,
            	    						"org.xtext.tdl.Tdl.RosNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getRobotAccess().getENDTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRobot"


    // $ANTLR start "entryRuleInitializationModule"
    // InternalTdlParser.g:647:1: entryRuleInitializationModule returns [EObject current=null] : iv_ruleInitializationModule= ruleInitializationModule EOF ;
    public final EObject entryRuleInitializationModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializationModule = null;


        try {
            // InternalTdlParser.g:647:61: (iv_ruleInitializationModule= ruleInitializationModule EOF )
            // InternalTdlParser.g:648:2: iv_ruleInitializationModule= ruleInitializationModule EOF
            {
             newCompositeNode(grammarAccess.getInitializationModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitializationModule=ruleInitializationModule();

            state._fsp--;

             current =iv_ruleInitializationModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationModule"


    // $ANTLR start "ruleInitializationModule"
    // InternalTdlParser.g:654:1: ruleInitializationModule returns [EObject current=null] : (otherlv_0= Setup this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END ) ;
    public final EObject ruleInitializationModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_BEGIN_1=null;
        Token this_END_3=null;
        AntlrDatatypeRuleToken lv_codeBlock_2_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:660:2: ( (otherlv_0= Setup this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END ) )
            // InternalTdlParser.g:661:2: (otherlv_0= Setup this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END )
            {
            // InternalTdlParser.g:661:2: (otherlv_0= Setup this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END )
            // InternalTdlParser.g:662:3: otherlv_0= Setup this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END
            {
            otherlv_0=(Token)match(input,Setup,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInitializationModuleAccess().getSetupKeyword_0());
            		
            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getInitializationModuleAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalTdlParser.g:670:3: ( (lv_codeBlock_2_0= ruleCodeBlock ) )
            // InternalTdlParser.g:671:4: (lv_codeBlock_2_0= ruleCodeBlock )
            {
            // InternalTdlParser.g:671:4: (lv_codeBlock_2_0= ruleCodeBlock )
            // InternalTdlParser.g:672:5: lv_codeBlock_2_0= ruleCodeBlock
            {

            					newCompositeNode(grammarAccess.getInitializationModuleAccess().getCodeBlockCodeBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_33);
            lv_codeBlock_2_0=ruleCodeBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitializationModuleRule());
            					}
            					set(
            						current,
            						"codeBlock",
            						lv_codeBlock_2_0,
            						"org.xtext.tdl.Tdl.CodeBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_END_3=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_3, grammarAccess.getInitializationModuleAccess().getENDTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitializationModule"


    // $ANTLR start "entryRuleSimpleAction"
    // InternalTdlParser.g:697:1: entryRuleSimpleAction returns [EObject current=null] : iv_ruleSimpleAction= ruleSimpleAction EOF ;
    public final EObject entryRuleSimpleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAction = null;


        try {
            // InternalTdlParser.g:697:53: (iv_ruleSimpleAction= ruleSimpleAction EOF )
            // InternalTdlParser.g:698:2: iv_ruleSimpleAction= ruleSimpleAction EOF
            {
             newCompositeNode(grammarAccess.getSimpleActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleAction=ruleSimpleAction();

            state._fsp--;

             current =iv_ruleSimpleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAction"


    // $ANTLR start "ruleSimpleAction"
    // InternalTdlParser.g:704:1: ruleSimpleAction returns [EObject current=null] : (otherlv_0= SimpleAction ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon ) this_BEGIN_7= RULE_BEGIN ( (lv_codeBlock_8_0= ruleCodeBlock ) ) this_END_9= RULE_END ) ;
    public final EObject ruleSimpleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_positional_5_0=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        EObject lv_parameters_3_0 = null;

        AntlrDatatypeRuleToken lv_codeBlock_8_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:710:2: ( (otherlv_0= SimpleAction ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon ) this_BEGIN_7= RULE_BEGIN ( (lv_codeBlock_8_0= ruleCodeBlock ) ) this_END_9= RULE_END ) )
            // InternalTdlParser.g:711:2: (otherlv_0= SimpleAction ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon ) this_BEGIN_7= RULE_BEGIN ( (lv_codeBlock_8_0= ruleCodeBlock ) ) this_END_9= RULE_END )
            {
            // InternalTdlParser.g:711:2: (otherlv_0= SimpleAction ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon ) this_BEGIN_7= RULE_BEGIN ( (lv_codeBlock_8_0= ruleCodeBlock ) ) this_END_9= RULE_END )
            // InternalTdlParser.g:712:3: otherlv_0= SimpleAction ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon ) this_BEGIN_7= RULE_BEGIN ( (lv_codeBlock_8_0= ruleCodeBlock ) ) this_END_9= RULE_END
            {
            otherlv_0=(Token)match(input,SimpleAction,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleActionAccess().getSimpleActionKeyword_0());
            		
            // InternalTdlParser.g:716:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTdlParser.g:717:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTdlParser.g:717:4: (lv_name_1_0= RULE_ID )
            // InternalTdlParser.g:718:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSimpleActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTdlParser.g:734:3: ( (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon ) | ( (lv_positional_5_0= LatLng ) ) | otherlv_6= LeftParenthesisRightParenthesisColon )
            int alt25=3;
            switch ( input.LA(1) ) {
            case LeftParenthesis:
                {
                alt25=1;
                }
                break;
            case LatLng:
                {
                alt25=2;
                }
                break;
            case LeftParenthesisRightParenthesisColon:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalTdlParser.g:735:4: (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon )
                    {
                    // InternalTdlParser.g:735:4: (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon )
                    // InternalTdlParser.g:736:5: otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleParameter ) )* otherlv_4= RightParenthesisColon
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); 

                    					newLeafNode(otherlv_2, grammarAccess.getSimpleActionAccess().getLeftParenthesisKeyword_2_0_0());
                    				
                    // InternalTdlParser.g:740:5: ( (lv_parameters_3_0= ruleParameter ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalTdlParser.g:741:6: (lv_parameters_3_0= ruleParameter )
                    	    {
                    	    // InternalTdlParser.g:741:6: (lv_parameters_3_0= ruleParameter )
                    	    // InternalTdlParser.g:742:7: lv_parameters_3_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleActionAccess().getParametersParameterParserRuleCall_2_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
                    	    lv_parameters_3_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSimpleActionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_3_0,
                    	    								"org.xtext.tdl.Tdl.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightParenthesisColon,FOLLOW_7); 

                    					newLeafNode(otherlv_4, grammarAccess.getSimpleActionAccess().getRightParenthesisColonKeyword_2_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTdlParser.g:765:4: ( (lv_positional_5_0= LatLng ) )
                    {
                    // InternalTdlParser.g:765:4: ( (lv_positional_5_0= LatLng ) )
                    // InternalTdlParser.g:766:5: (lv_positional_5_0= LatLng )
                    {
                    // InternalTdlParser.g:766:5: (lv_positional_5_0= LatLng )
                    // InternalTdlParser.g:767:6: lv_positional_5_0= LatLng
                    {
                    lv_positional_5_0=(Token)match(input,LatLng,FOLLOW_7); 

                    						newLeafNode(lv_positional_5_0, grammarAccess.getSimpleActionAccess().getPositionalLatLngKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleActionRule());
                    						}
                    						setWithLastConsumed(current, "positional", lv_positional_5_0, "(lat,lng):");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTdlParser.g:780:4: otherlv_6= LeftParenthesisRightParenthesisColon
                    {
                    otherlv_6=(Token)match(input,LeftParenthesisRightParenthesisColon,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getSimpleActionAccess().getLeftParenthesisRightParenthesisColonKeyword_2_2());
                    			

                    }
                    break;

            }

            this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

            			newLeafNode(this_BEGIN_7, grammarAccess.getSimpleActionAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalTdlParser.g:789:3: ( (lv_codeBlock_8_0= ruleCodeBlock ) )
            // InternalTdlParser.g:790:4: (lv_codeBlock_8_0= ruleCodeBlock )
            {
            // InternalTdlParser.g:790:4: (lv_codeBlock_8_0= ruleCodeBlock )
            // InternalTdlParser.g:791:5: lv_codeBlock_8_0= ruleCodeBlock
            {

            					newCompositeNode(grammarAccess.getSimpleActionAccess().getCodeBlockCodeBlockParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_33);
            lv_codeBlock_8_0=ruleCodeBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleActionRule());
            					}
            					set(
            						current,
            						"codeBlock",
            						lv_codeBlock_8_0,
            						"org.xtext.tdl.Tdl.CodeBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getSimpleActionAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAction"


    // $ANTLR start "entryRuleParameter"
    // InternalTdlParser.g:816:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalTdlParser.g:816:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalTdlParser.g:817:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalTdlParser.g:823:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= Comma )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTdlParser.g:829:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= Comma )? ) )
            // InternalTdlParser.g:830:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= Comma )? )
            {
            // InternalTdlParser.g:830:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= Comma )? )
            // InternalTdlParser.g:831:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= Comma )?
            {
            // InternalTdlParser.g:831:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTdlParser.g:832:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTdlParser.g:832:4: (lv_name_0_0= RULE_ID )
            // InternalTdlParser.g:833:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTdlParser.g:849:3: (otherlv_1= Comma )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Comma) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTdlParser.g:850:4: otherlv_1= Comma
                    {
                    otherlv_1=(Token)match(input,Comma,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getCommaKeyword_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleRosNode"
    // InternalTdlParser.g:859:1: entryRuleRosNode returns [EObject current=null] : iv_ruleRosNode= ruleRosNode EOF ;
    public final EObject entryRuleRosNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosNode = null;


        try {
            // InternalTdlParser.g:859:48: (iv_ruleRosNode= ruleRosNode EOF )
            // InternalTdlParser.g:860:2: iv_ruleRosNode= ruleRosNode EOF
            {
             newCompositeNode(grammarAccess.getRosNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRosNode=ruleRosNode();

            state._fsp--;

             current =iv_ruleRosNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosNode"


    // $ANTLR start "ruleRosNode"
    // InternalTdlParser.g:866:1: ruleRosNode returns [EObject current=null] : ( (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END ) | (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? ) ) ;
    public final EObject ruleRosNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token lv_nodeType_9_0=null;
        Token otherlv_10=null;
        Token lv_nodeName_11_0=null;
        Token otherlv_12=null;
        Token lv_nodeArgs_13_0=null;
        Token otherlv_14=null;
        Token this_BEGIN_15=null;
        Token this_END_17=null;
        AntlrDatatypeRuleToken lv_codeBlock_4_0 = null;

        EObject lv_parameterList_16_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:872:2: ( ( (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END ) | (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? ) ) )
            // InternalTdlParser.g:873:2: ( (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END ) | (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? ) )
            {
            // InternalTdlParser.g:873:2: ( (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END ) | (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RosNode) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==RULE_ID) ) {
                    int LA29_2 = input.LA(3);

                    if ( (LA29_2==LeftParenthesisRightParenthesisColon) ) {
                        alt29=1;
                    }
                    else if ( (LA29_2==LeftParenthesis) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalTdlParser.g:874:3: (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END )
                    {
                    // InternalTdlParser.g:874:3: (otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END )
                    // InternalTdlParser.g:875:4: otherlv_0= RosNode ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesisRightParenthesisColon this_BEGIN_3= RULE_BEGIN ( (lv_codeBlock_4_0= ruleCodeBlock ) ) this_END_5= RULE_END
                    {
                    otherlv_0=(Token)match(input,RosNode,FOLLOW_5); 

                    				newLeafNode(otherlv_0, grammarAccess.getRosNodeAccess().getRosNodeKeyword_0_0());
                    			
                    // InternalTdlParser.g:879:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalTdlParser.g:880:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalTdlParser.g:880:5: (lv_name_1_0= RULE_ID )
                    // InternalTdlParser.g:881:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getRosNodeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRosNodeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,LeftParenthesisRightParenthesisColon,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getRosNodeAccess().getLeftParenthesisRightParenthesisColonKeyword_0_2());
                    			
                    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

                    				newLeafNode(this_BEGIN_3, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_0_3());
                    			
                    // InternalTdlParser.g:905:4: ( (lv_codeBlock_4_0= ruleCodeBlock ) )
                    // InternalTdlParser.g:906:5: (lv_codeBlock_4_0= ruleCodeBlock )
                    {
                    // InternalTdlParser.g:906:5: (lv_codeBlock_4_0= ruleCodeBlock )
                    // InternalTdlParser.g:907:6: lv_codeBlock_4_0= ruleCodeBlock
                    {

                    						newCompositeNode(grammarAccess.getRosNodeAccess().getCodeBlockCodeBlockParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_codeBlock_4_0=ruleCodeBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    						}
                    						set(
                    							current,
                    							"codeBlock",
                    							lv_codeBlock_4_0,
                    							"org.xtext.tdl.Tdl.CodeBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

                    				newLeafNode(this_END_5, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTdlParser.g:930:3: (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? )
                    {
                    // InternalTdlParser.g:930:3: (otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )? )
                    // InternalTdlParser.g:931:4: otherlv_6= RosNode ( (lv_name_7_0= RULE_ID ) ) otherlv_8= LeftParenthesis ( (lv_nodeType_9_0= RULE_STRING ) ) otherlv_10= Comma ( (lv_nodeName_11_0= RULE_STRING ) ) (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )? otherlv_14= RightParenthesisColon (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )?
                    {
                    otherlv_6=(Token)match(input,RosNode,FOLLOW_5); 

                    				newLeafNode(otherlv_6, grammarAccess.getRosNodeAccess().getRosNodeKeyword_1_0());
                    			
                    // InternalTdlParser.g:935:4: ( (lv_name_7_0= RULE_ID ) )
                    // InternalTdlParser.g:936:5: (lv_name_7_0= RULE_ID )
                    {
                    // InternalTdlParser.g:936:5: (lv_name_7_0= RULE_ID )
                    // InternalTdlParser.g:937:6: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_35); 

                    						newLeafNode(lv_name_7_0, grammarAccess.getRosNodeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRosNodeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_7_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,LeftParenthesis,FOLLOW_13); 

                    				newLeafNode(otherlv_8, grammarAccess.getRosNodeAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalTdlParser.g:957:4: ( (lv_nodeType_9_0= RULE_STRING ) )
                    // InternalTdlParser.g:958:5: (lv_nodeType_9_0= RULE_STRING )
                    {
                    // InternalTdlParser.g:958:5: (lv_nodeType_9_0= RULE_STRING )
                    // InternalTdlParser.g:959:6: lv_nodeType_9_0= RULE_STRING
                    {
                    lv_nodeType_9_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

                    						newLeafNode(lv_nodeType_9_0, grammarAccess.getRosNodeAccess().getNodeTypeSTRINGTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRosNodeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"nodeType",
                    							lv_nodeType_9_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,Comma,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getRosNodeAccess().getCommaKeyword_1_4());
                    			
                    // InternalTdlParser.g:979:4: ( (lv_nodeName_11_0= RULE_STRING ) )
                    // InternalTdlParser.g:980:5: (lv_nodeName_11_0= RULE_STRING )
                    {
                    // InternalTdlParser.g:980:5: (lv_nodeName_11_0= RULE_STRING )
                    // InternalTdlParser.g:981:6: lv_nodeName_11_0= RULE_STRING
                    {
                    lv_nodeName_11_0=(Token)match(input,RULE_STRING,FOLLOW_37); 

                    						newLeafNode(lv_nodeName_11_0, grammarAccess.getRosNodeAccess().getNodeNameSTRINGTerminalRuleCall_1_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRosNodeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"nodeName",
                    							lv_nodeName_11_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalTdlParser.g:997:4: (otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==Comma) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalTdlParser.g:998:5: otherlv_12= Comma ( (lv_nodeArgs_13_0= RULE_STRING ) )
                            {
                            otherlv_12=(Token)match(input,Comma,FOLLOW_13); 

                            					newLeafNode(otherlv_12, grammarAccess.getRosNodeAccess().getCommaKeyword_1_6_0());
                            				
                            // InternalTdlParser.g:1002:5: ( (lv_nodeArgs_13_0= RULE_STRING ) )
                            // InternalTdlParser.g:1003:6: (lv_nodeArgs_13_0= RULE_STRING )
                            {
                            // InternalTdlParser.g:1003:6: (lv_nodeArgs_13_0= RULE_STRING )
                            // InternalTdlParser.g:1004:7: lv_nodeArgs_13_0= RULE_STRING
                            {
                            lv_nodeArgs_13_0=(Token)match(input,RULE_STRING,FOLLOW_38); 

                            							newLeafNode(lv_nodeArgs_13_0, grammarAccess.getRosNodeAccess().getNodeArgsSTRINGTerminalRuleCall_1_6_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getRosNodeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"nodeArgs",
                            								lv_nodeArgs_13_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,RightParenthesisColon,FOLLOW_39); 

                    				newLeafNode(otherlv_14, grammarAccess.getRosNodeAccess().getRightParenthesisColonKeyword_1_7());
                    			
                    // InternalTdlParser.g:1025:4: (this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_BEGIN) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalTdlParser.g:1026:5: this_BEGIN_15= RULE_BEGIN ( (lv_parameterList_16_0= ruleParameterList ) ) this_END_17= RULE_END
                            {
                            this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_40); 

                            					newLeafNode(this_BEGIN_15, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_1_8_0());
                            				
                            // InternalTdlParser.g:1030:5: ( (lv_parameterList_16_0= ruleParameterList ) )
                            // InternalTdlParser.g:1031:6: (lv_parameterList_16_0= ruleParameterList )
                            {
                            // InternalTdlParser.g:1031:6: (lv_parameterList_16_0= ruleParameterList )
                            // InternalTdlParser.g:1032:7: lv_parameterList_16_0= ruleParameterList
                            {

                            							newCompositeNode(grammarAccess.getRosNodeAccess().getParameterListParameterListParserRuleCall_1_8_1_0());
                            						
                            pushFollow(FOLLOW_33);
                            lv_parameterList_16_0=ruleParameterList();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRosNodeRule());
                            							}
                            							set(
                            								current,
                            								"parameterList",
                            								lv_parameterList_16_0,
                            								"org.xtext.tdl.Tdl.ParameterList");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            this_END_17=(Token)match(input,RULE_END,FOLLOW_2); 

                            					newLeafNode(this_END_17, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_1_8_2());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosNode"


    // $ANTLR start "entryRuleParameterList"
    // InternalTdlParser.g:1059:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalTdlParser.g:1059:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalTdlParser.g:1060:2: iv_ruleParameterList= ruleParameterList EOF
            {
             newCompositeNode(grammarAccess.getParameterListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;

             current =iv_ruleParameterList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalTdlParser.g:1066:1: ruleParameterList returns [EObject current=null] : (otherlv_0= Parameters this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_BEGIN_1=null;
        Token this_END_3=null;
        AntlrDatatypeRuleToken lv_codeBlock_2_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:1072:2: ( (otherlv_0= Parameters this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END ) )
            // InternalTdlParser.g:1073:2: (otherlv_0= Parameters this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END )
            {
            // InternalTdlParser.g:1073:2: (otherlv_0= Parameters this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END )
            // InternalTdlParser.g:1074:3: otherlv_0= Parameters this_BEGIN_1= RULE_BEGIN ( (lv_codeBlock_2_0= ruleCodeBlock ) ) this_END_3= RULE_END
            {
            otherlv_0=(Token)match(input,Parameters,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterListAccess().getParametersKeyword_0());
            		
            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getParameterListAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalTdlParser.g:1082:3: ( (lv_codeBlock_2_0= ruleCodeBlock ) )
            // InternalTdlParser.g:1083:4: (lv_codeBlock_2_0= ruleCodeBlock )
            {
            // InternalTdlParser.g:1083:4: (lv_codeBlock_2_0= ruleCodeBlock )
            // InternalTdlParser.g:1084:5: lv_codeBlock_2_0= ruleCodeBlock
            {

            					newCompositeNode(grammarAccess.getParameterListAccess().getCodeBlockCodeBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_33);
            lv_codeBlock_2_0=ruleCodeBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterListRule());
            					}
            					set(
            						current,
            						"codeBlock",
            						lv_codeBlock_2_0,
            						"org.xtext.tdl.Tdl.CodeBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_END_3=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_3, grammarAccess.getParameterListAccess().getENDTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRulePublishedData"
    // InternalTdlParser.g:1109:1: entryRulePublishedData returns [EObject current=null] : iv_rulePublishedData= rulePublishedData EOF ;
    public final EObject entryRulePublishedData() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublishedData = null;


        try {
            // InternalTdlParser.g:1109:54: (iv_rulePublishedData= rulePublishedData EOF )
            // InternalTdlParser.g:1110:2: iv_rulePublishedData= rulePublishedData EOF
            {
             newCompositeNode(grammarAccess.getPublishedDataRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePublishedData=rulePublishedData();

            state._fsp--;

             current =iv_rulePublishedData; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePublishedData"


    // $ANTLR start "rulePublishedData"
    // InternalTdlParser.g:1116:1: rulePublishedData returns [EObject current=null] : (otherlv_0= PublishedData this_BEGIN_1= RULE_BEGIN ( (lv_topics_2_0= ruleTopic ) )* this_END_3= RULE_END ) ;
    public final EObject rulePublishedData() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_topics_2_0 = null;



        	enterRule();

        try {
            // InternalTdlParser.g:1122:2: ( (otherlv_0= PublishedData this_BEGIN_1= RULE_BEGIN ( (lv_topics_2_0= ruleTopic ) )* this_END_3= RULE_END ) )
            // InternalTdlParser.g:1123:2: (otherlv_0= PublishedData this_BEGIN_1= RULE_BEGIN ( (lv_topics_2_0= ruleTopic ) )* this_END_3= RULE_END )
            {
            // InternalTdlParser.g:1123:2: (otherlv_0= PublishedData this_BEGIN_1= RULE_BEGIN ( (lv_topics_2_0= ruleTopic ) )* this_END_3= RULE_END )
            // InternalTdlParser.g:1124:3: otherlv_0= PublishedData this_BEGIN_1= RULE_BEGIN ( (lv_topics_2_0= ruleTopic ) )* this_END_3= RULE_END
            {
            otherlv_0=(Token)match(input,PublishedData,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPublishedDataAccess().getPublishedDataKeyword_0());
            		
            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_10); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getPublishedDataAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalTdlParser.g:1132:3: ( (lv_topics_2_0= ruleTopic ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalTdlParser.g:1133:4: (lv_topics_2_0= ruleTopic )
            	    {
            	    // InternalTdlParser.g:1133:4: (lv_topics_2_0= ruleTopic )
            	    // InternalTdlParser.g:1134:5: lv_topics_2_0= ruleTopic
            	    {

            	    					newCompositeNode(grammarAccess.getPublishedDataAccess().getTopicsTopicParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_topics_2_0=ruleTopic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPublishedDataRule());
            	    					}
            	    					add(
            	    						current,
            	    						"topics",
            	    						lv_topics_2_0,
            	    						"org.xtext.tdl.Tdl.Topic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            this_END_3=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_3, grammarAccess.getPublishedDataAccess().getENDTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePublishedData"


    // $ANTLR start "entryRuleTopic"
    // InternalTdlParser.g:1159:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // InternalTdlParser.g:1159:46: (iv_ruleTopic= ruleTopic EOF )
            // InternalTdlParser.g:1160:2: iv_ruleTopic= ruleTopic EOF
            {
             newCompositeNode(grammarAccess.getTopicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopic=ruleTopic();

            state._fsp--;

             current =iv_ruleTopic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopic"


    // $ANTLR start "ruleTopic"
    // InternalTdlParser.g:1166:1: ruleTopic returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_topic_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_topic_2_0=null;


        	enterRule();

        try {
            // InternalTdlParser.g:1172:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_topic_2_0= RULE_STRING ) ) ) )
            // InternalTdlParser.g:1173:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_topic_2_0= RULE_STRING ) ) )
            {
            // InternalTdlParser.g:1173:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_topic_2_0= RULE_STRING ) ) )
            // InternalTdlParser.g:1174:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_topic_2_0= RULE_STRING ) )
            {
            // InternalTdlParser.g:1174:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTdlParser.g:1175:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTdlParser.g:1175:4: (lv_name_0_0= RULE_ID )
            // InternalTdlParser.g:1176:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTopicAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTopicRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTopicAccess().getColonKeyword_1());
            		
            // InternalTdlParser.g:1196:3: ( (lv_topic_2_0= RULE_STRING ) )
            // InternalTdlParser.g:1197:4: (lv_topic_2_0= RULE_STRING )
            {
            // InternalTdlParser.g:1197:4: (lv_topic_2_0= RULE_STRING )
            // InternalTdlParser.g:1198:5: lv_topic_2_0= RULE_STRING
            {
            lv_topic_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_topic_2_0, grammarAccess.getTopicAccess().getTopicSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTopicRule());
            					}
            					setWithLastConsumed(
            						current,
            						"topic",
            						lv_topic_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopic"


    // $ANTLR start "entryRuleCodeBlock"
    // InternalTdlParser.g:1218:1: entryRuleCodeBlock returns [String current=null] : iv_ruleCodeBlock= ruleCodeBlock EOF ;
    public final String entryRuleCodeBlock() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCodeBlock = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTdlParser.g:1220:2: (iv_ruleCodeBlock= ruleCodeBlock EOF )
            // InternalTdlParser.g:1221:2: iv_ruleCodeBlock= ruleCodeBlock EOF
            {
             newCompositeNode(grammarAccess.getCodeBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodeBlock=ruleCodeBlock();

            state._fsp--;

             current =iv_ruleCodeBlock.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCodeBlock"


    // $ANTLR start "ruleCodeBlock"
    // InternalTdlParser.g:1230:1: ruleCodeBlock returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_WS_1= RULE_WS | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_ML_COMMENT_4= RULE_ML_COMMENT | this_SL_COMMENT_5= RULE_SL_COMMENT | this_ANY_OTHER_6= RULE_ANY_OTHER | kw= LeftParenthesis | kw= RightParenthesis | kw= RightParenthesisColon | kw= LeftParenthesisRightParenthesis | kw= Colon | kw= Apostrophe | kw= Comma | kw= RightParenthesisRightParenthesis | this_CodeBlock_2_15= ruleCodeBlock_2 )* ;
    public final AntlrDatatypeRuleToken ruleCodeBlock() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_WS_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token this_ML_COMMENT_4=null;
        Token this_SL_COMMENT_5=null;
        Token this_ANY_OTHER_6=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_CodeBlock_2_15 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTdlParser.g:1237:2: ( (this_ID_0= RULE_ID | this_WS_1= RULE_WS | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_ML_COMMENT_4= RULE_ML_COMMENT | this_SL_COMMENT_5= RULE_SL_COMMENT | this_ANY_OTHER_6= RULE_ANY_OTHER | kw= LeftParenthesis | kw= RightParenthesis | kw= RightParenthesisColon | kw= LeftParenthesisRightParenthesis | kw= Colon | kw= Apostrophe | kw= Comma | kw= RightParenthesisRightParenthesis | this_CodeBlock_2_15= ruleCodeBlock_2 )* )
            // InternalTdlParser.g:1238:2: (this_ID_0= RULE_ID | this_WS_1= RULE_WS | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_ML_COMMENT_4= RULE_ML_COMMENT | this_SL_COMMENT_5= RULE_SL_COMMENT | this_ANY_OTHER_6= RULE_ANY_OTHER | kw= LeftParenthesis | kw= RightParenthesis | kw= RightParenthesisColon | kw= LeftParenthesisRightParenthesis | kw= Colon | kw= Apostrophe | kw= Comma | kw= RightParenthesisRightParenthesis | this_CodeBlock_2_15= ruleCodeBlock_2 )*
            {
            // InternalTdlParser.g:1238:2: (this_ID_0= RULE_ID | this_WS_1= RULE_WS | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_ML_COMMENT_4= RULE_ML_COMMENT | this_SL_COMMENT_5= RULE_SL_COMMENT | this_ANY_OTHER_6= RULE_ANY_OTHER | kw= LeftParenthesis | kw= RightParenthesis | kw= RightParenthesisColon | kw= LeftParenthesisRightParenthesis | kw= Colon | kw= Apostrophe | kw= Comma | kw= RightParenthesisRightParenthesis | this_CodeBlock_2_15= ruleCodeBlock_2 )*
            loop31:
            do {
                int alt31=17;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt31=1;
                    }
                    break;
                case RULE_WS:
                    {
                    alt31=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt31=3;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt31=4;
                    }
                    break;
                case RULE_ML_COMMENT:
                    {
                    alt31=5;
                    }
                    break;
                case RULE_SL_COMMENT:
                    {
                    alt31=6;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt31=7;
                    }
                    break;
                case LeftParenthesis:
                    {
                    alt31=8;
                    }
                    break;
                case RightParenthesis:
                    {
                    alt31=9;
                    }
                    break;
                case RightParenthesisColon:
                    {
                    alt31=10;
                    }
                    break;
                case LeftParenthesisRightParenthesis:
                    {
                    alt31=11;
                    }
                    break;
                case Colon:
                    {
                    alt31=12;
                    }
                    break;
                case Apostrophe:
                    {
                    alt31=13;
                    }
                    break;
                case Comma:
                    {
                    alt31=14;
                    }
                    break;
                case RightParenthesisRightParenthesis:
                    {
                    alt31=15;
                    }
                    break;
                case RULE_BEGIN:
                    {
                    alt31=16;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalTdlParser.g:1239:3: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            	    			current.merge(this_ID_0);
            	    		

            	    			newLeafNode(this_ID_0, grammarAccess.getCodeBlockAccess().getIDTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalTdlParser.g:1247:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_41); 

            	    			current.merge(this_WS_1);
            	    		

            	    			newLeafNode(this_WS_1, grammarAccess.getCodeBlockAccess().getWSTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalTdlParser.g:1255:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_41); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getCodeBlockAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalTdlParser.g:1263:3: this_STRING_3= RULE_STRING
            	    {
            	    this_STRING_3=(Token)match(input,RULE_STRING,FOLLOW_41); 

            	    			current.merge(this_STRING_3);
            	    		

            	    			newLeafNode(this_STRING_3, grammarAccess.getCodeBlockAccess().getSTRINGTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalTdlParser.g:1271:3: this_ML_COMMENT_4= RULE_ML_COMMENT
            	    {
            	    this_ML_COMMENT_4=(Token)match(input,RULE_ML_COMMENT,FOLLOW_41); 

            	    			current.merge(this_ML_COMMENT_4);
            	    		

            	    			newLeafNode(this_ML_COMMENT_4, grammarAccess.getCodeBlockAccess().getML_COMMENTTerminalRuleCall_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalTdlParser.g:1279:3: this_SL_COMMENT_5= RULE_SL_COMMENT
            	    {
            	    this_SL_COMMENT_5=(Token)match(input,RULE_SL_COMMENT,FOLLOW_41); 

            	    			current.merge(this_SL_COMMENT_5);
            	    		

            	    			newLeafNode(this_SL_COMMENT_5, grammarAccess.getCodeBlockAccess().getSL_COMMENTTerminalRuleCall_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalTdlParser.g:1287:3: this_ANY_OTHER_6= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_6=(Token)match(input,RULE_ANY_OTHER,FOLLOW_41); 

            	    			current.merge(this_ANY_OTHER_6);
            	    		

            	    			newLeafNode(this_ANY_OTHER_6, grammarAccess.getCodeBlockAccess().getANY_OTHERTerminalRuleCall_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalTdlParser.g:1295:3: kw= LeftParenthesis
            	    {
            	    kw=(Token)match(input,LeftParenthesis,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getLeftParenthesisKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalTdlParser.g:1301:3: kw= RightParenthesis
            	    {
            	    kw=(Token)match(input,RightParenthesis,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getRightParenthesisKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalTdlParser.g:1307:3: kw= RightParenthesisColon
            	    {
            	    kw=(Token)match(input,RightParenthesisColon,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getRightParenthesisColonKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalTdlParser.g:1313:3: kw= LeftParenthesisRightParenthesis
            	    {
            	    kw=(Token)match(input,LeftParenthesisRightParenthesis,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getLeftParenthesisRightParenthesisKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalTdlParser.g:1319:3: kw= Colon
            	    {
            	    kw=(Token)match(input,Colon,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getColonKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalTdlParser.g:1325:3: kw= Apostrophe
            	    {
            	    kw=(Token)match(input,Apostrophe,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getApostropheKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalTdlParser.g:1331:3: kw= Comma
            	    {
            	    kw=(Token)match(input,Comma,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getCommaKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalTdlParser.g:1337:3: kw= RightParenthesisRightParenthesis
            	    {
            	    kw=(Token)match(input,RightParenthesisRightParenthesis,FOLLOW_41); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getCodeBlockAccess().getRightParenthesisRightParenthesisKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalTdlParser.g:1343:3: this_CodeBlock_2_15= ruleCodeBlock_2
            	    {

            	    			newCompositeNode(grammarAccess.getCodeBlockAccess().getCodeBlock_2ParserRuleCall_15());
            	    		
            	    pushFollow(FOLLOW_41);
            	    this_CodeBlock_2_15=ruleCodeBlock_2();

            	    state._fsp--;


            	    			current.merge(this_CodeBlock_2_15);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCodeBlock"


    // $ANTLR start "entryRuleCodeBlock_2"
    // InternalTdlParser.g:1360:1: entryRuleCodeBlock_2 returns [String current=null] : iv_ruleCodeBlock_2= ruleCodeBlock_2 EOF ;
    public final String entryRuleCodeBlock_2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCodeBlock_2 = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTdlParser.g:1362:2: (iv_ruleCodeBlock_2= ruleCodeBlock_2 EOF )
            // InternalTdlParser.g:1363:2: iv_ruleCodeBlock_2= ruleCodeBlock_2 EOF
            {
             newCompositeNode(grammarAccess.getCodeBlock_2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodeBlock_2=ruleCodeBlock_2();

            state._fsp--;

             current =iv_ruleCodeBlock_2.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCodeBlock_2"


    // $ANTLR start "ruleCodeBlock_2"
    // InternalTdlParser.g:1372:1: ruleCodeBlock_2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BEGIN_0= RULE_BEGIN this_CodeBlock_1= ruleCodeBlock this_END_2= RULE_END ) ;
    public final AntlrDatatypeRuleToken ruleCodeBlock_2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BEGIN_0=null;
        Token this_END_2=null;
        AntlrDatatypeRuleToken this_CodeBlock_1 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalTdlParser.g:1379:2: ( (this_BEGIN_0= RULE_BEGIN this_CodeBlock_1= ruleCodeBlock this_END_2= RULE_END ) )
            // InternalTdlParser.g:1380:2: (this_BEGIN_0= RULE_BEGIN this_CodeBlock_1= ruleCodeBlock this_END_2= RULE_END )
            {
            // InternalTdlParser.g:1380:2: (this_BEGIN_0= RULE_BEGIN this_CodeBlock_1= ruleCodeBlock this_END_2= RULE_END )
            // InternalTdlParser.g:1381:3: this_BEGIN_0= RULE_BEGIN this_CodeBlock_1= ruleCodeBlock this_END_2= RULE_END
            {
            this_BEGIN_0=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

            			current.merge(this_BEGIN_0);
            		

            			newLeafNode(this_BEGIN_0, grammarAccess.getCodeBlock_2Access().getBEGINTerminalRuleCall_0());
            		

            			newCompositeNode(grammarAccess.getCodeBlock_2Access().getCodeBlockParserRuleCall_1());
            		
            pushFollow(FOLLOW_33);
            this_CodeBlock_1=ruleCodeBlock();

            state._fsp--;


            			current.merge(this_CodeBlock_1);
            		

            			afterParserOrEnumRuleCall();
            		
            this_END_2=(Token)match(input,RULE_END,FOLLOW_2); 

            			current.merge(this_END_2);
            		

            			newLeafNode(this_END_2, grammarAccess.getCodeBlock_2Access().getENDTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCodeBlock_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000810100L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000264C00L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002224C00L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000224C00L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000003220C00L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002220C00L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000220C00L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000003220800L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002220800L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000220800L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000083220000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002220000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010001250L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010001240L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000240L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000010000200L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000FFFF80000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000FEFF80002L});

}