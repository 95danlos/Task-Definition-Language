package org.xtext.tdl.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTdlLexer extends Lexer {
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

    public InternalTdlLexer() {;} 
    public InternalTdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTdlLexer.g"; }

    // $ANTLR start "PublishedData"
    public final void mPublishedData() throws RecognitionException {
        try {
            int _type = PublishedData;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:14:15: ( 'PublishedData:' )
            // InternalTdlLexer.g:14:17: 'PublishedData:'
            {
            match("PublishedData:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PublishedData"

    // $ANTLR start "CompositeTask"
    public final void mCompositeTask() throws RecognitionException {
        try {
            int _type = CompositeTask;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:16:15: ( 'compositeTask' )
            // InternalTdlLexer.g:16:17: 'compositeTask'
            {
            match("compositeTask"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CompositeTask"

    // $ANTLR start "SimpleAction"
    public final void mSimpleAction() throws RecognitionException {
        try {
            int _type = SimpleAction;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:18:14: ( 'simpleAction' )
            // InternalTdlLexer.g:18:16: 'simpleAction'
            {
            match("simpleAction"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SimpleAction"

    // $ANTLR start "Parameters"
    public final void mParameters() throws RecognitionException {
        try {
            int _type = Parameters;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:20:12: ( 'Parameters:' )
            // InternalTdlLexer.g:20:14: 'Parameters:'
            {
            match("Parameters:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Parameters"

    // $ANTLR start "LatLng"
    public final void mLatLng() throws RecognitionException {
        try {
            int _type = LatLng;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:22:8: ( '(lat,lng):' )
            // InternalTdlLexer.g:22:10: '(lat,lng):'
            {
            match("(lat,lng):"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LatLng"

    // $ANTLR start "RosNode"
    public final void mRosNode() throws RecognitionException {
        try {
            int _type = RosNode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:24:9: ( 'rosNode' )
            // InternalTdlLexer.g:24:11: 'rosNode'
            {
            match("rosNode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RosNode"

    // $ANTLR start "After"
    public final void mAfter() throws RecognitionException {
        try {
            int _type = After;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:26:7: ( 'after(' )
            // InternalTdlLexer.g:26:9: 'after('
            {
            match("after("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "After"

    // $ANTLR start "Args"
    public final void mArgs() throws RecognitionException {
        try {
            int _type = Args;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:28:6: ( 'args=(' )
            // InternalTdlLexer.g:28:8: 'args=('
            {
            match("args=("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Args"

    // $ANTLR start "Setup"
    public final void mSetup() throws RecognitionException {
        try {
            int _type = Setup;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:30:7: ( 'setup:' )
            // InternalTdlLexer.g:30:9: 'setup:'
            {
            match("setup:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Setup"

    // $ANTLR start "Robot"
    public final void mRobot() throws RecognitionException {
        try {
            int _type = Robot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:32:7: ( 'robot' )
            // InternalTdlLexer.g:32:9: 'robot'
            {
            match("robot"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Robot"

    // $ANTLR start "Sync"
    public final void mSync() throws RecognitionException {
        try {
            int _type = Sync;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:34:6: ( 'sync(' )
            // InternalTdlLexer.g:34:8: 'sync('
            {
            match("sync("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sync"

    // $ANTLR start "Task"
    public final void mTask() throws RecognitionException {
        try {
            int _type = Task;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:36:6: ( 'task' )
            // InternalTdlLexer.g:36:8: 'task'
            {
            match("task"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Task"

    // $ANTLR start "LeftParenthesisRightParenthesisColon"
    public final void mLeftParenthesisRightParenthesisColon() throws RecognitionException {
        try {
            int _type = LeftParenthesisRightParenthesisColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:38:38: ( '():' )
            // InternalTdlLexer.g:38:40: '():'
            {
            match("():"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesisRightParenthesisColon"

    // $ANTLR start "RightParenthesisRightParenthesisColon"
    public final void mRightParenthesisRightParenthesisColon() throws RecognitionException {
        try {
            int _type = RightParenthesisRightParenthesisColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:40:39: ( ')):' )
            // InternalTdlLexer.g:40:41: ')):'
            {
            match(")):"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesisRightParenthesisColon"

    // $ANTLR start "Id"
    public final void mId() throws RecognitionException {
        try {
            int _type = Id;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:42:4: ( 'id=' )
            // InternalTdlLexer.g:42:6: 'id='
            {
            match("id="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Id"

    // $ANTLR start "LeftParenthesisRightParenthesis"
    public final void mLeftParenthesisRightParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesisRightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:44:33: ( '()' )
            // InternalTdlLexer.g:44:35: '()'
            {
            match("()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesisRightParenthesis"

    // $ANTLR start "RightParenthesisRightParenthesis"
    public final void mRightParenthesisRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesisRightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:46:34: ( '))' )
            // InternalTdlLexer.g:46:36: '))'
            {
            match("))"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesisRightParenthesis"

    // $ANTLR start "RightParenthesisColon"
    public final void mRightParenthesisColon() throws RecognitionException {
        try {
            int _type = RightParenthesisColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:48:23: ( '):' )
            // InternalTdlLexer.g:48:25: '):'
            {
            match("):"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesisColon"

    // $ANTLR start "Apostrophe"
    public final void mApostrophe() throws RecognitionException {
        try {
            int _type = Apostrophe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:50:12: ( '\\'' )
            // InternalTdlLexer.g:50:14: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Apostrophe"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:52:17: ( '(' )
            // InternalTdlLexer.g:52:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:54:18: ( ')' )
            // InternalTdlLexer.g:54:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:56:7: ( ',' )
            // InternalTdlLexer.g:56:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:58:7: ( ':' )
            // InternalTdlLexer.g:58:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalTdlLexer.g:60:21: ()
            // InternalTdlLexer.g:60:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalTdlLexer.g:62:19: ()
            // InternalTdlLexer.g:62:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:64:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalTdlLexer.g:64:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalTdlLexer.g:64:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTdlLexer.g:64:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTdlLexer.g:64:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTdlLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:66:10: ( ( '0' .. '9' )+ )
            // InternalTdlLexer.g:66:12: ( '0' .. '9' )+
            {
            // InternalTdlLexer.g:66:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTdlLexer.g:66:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:68:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalTdlLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalTdlLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTdlLexer.g:68:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalTdlLexer.g:68:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalTdlLexer.g:68:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTdlLexer.g:68:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalTdlLexer.g:68:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalTdlLexer.g:68:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalTdlLexer.g:68:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTdlLexer.g:68:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:70:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTdlLexer.g:70:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTdlLexer.g:70:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTdlLexer.g:70:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:72:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTdlLexer.g:72:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTdlLexer.g:72:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalTdlLexer.g:72:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalTdlLexer.g:72:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTdlLexer.g:72:41: ( '\\r' )? '\\n'
                    {
                    // InternalTdlLexer.g:72:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalTdlLexer.g:72:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:74:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTdlLexer.g:74:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTdlLexer.g:74:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTdlLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTdlLexer.g:76:16: ( . )
            // InternalTdlLexer.g:76:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalTdlLexer.g:1:8: ( PublishedData | CompositeTask | SimpleAction | Parameters | LatLng | RosNode | After | Args | Setup | Robot | Sync | Task | LeftParenthesisRightParenthesisColon | RightParenthesisRightParenthesisColon | Id | LeftParenthesisRightParenthesis | RightParenthesisRightParenthesis | RightParenthesisColon | Apostrophe | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=30;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalTdlLexer.g:1:10: PublishedData
                {
                mPublishedData(); 

                }
                break;
            case 2 :
                // InternalTdlLexer.g:1:24: CompositeTask
                {
                mCompositeTask(); 

                }
                break;
            case 3 :
                // InternalTdlLexer.g:1:38: SimpleAction
                {
                mSimpleAction(); 

                }
                break;
            case 4 :
                // InternalTdlLexer.g:1:51: Parameters
                {
                mParameters(); 

                }
                break;
            case 5 :
                // InternalTdlLexer.g:1:62: LatLng
                {
                mLatLng(); 

                }
                break;
            case 6 :
                // InternalTdlLexer.g:1:69: RosNode
                {
                mRosNode(); 

                }
                break;
            case 7 :
                // InternalTdlLexer.g:1:77: After
                {
                mAfter(); 

                }
                break;
            case 8 :
                // InternalTdlLexer.g:1:83: Args
                {
                mArgs(); 

                }
                break;
            case 9 :
                // InternalTdlLexer.g:1:88: Setup
                {
                mSetup(); 

                }
                break;
            case 10 :
                // InternalTdlLexer.g:1:94: Robot
                {
                mRobot(); 

                }
                break;
            case 11 :
                // InternalTdlLexer.g:1:100: Sync
                {
                mSync(); 

                }
                break;
            case 12 :
                // InternalTdlLexer.g:1:105: Task
                {
                mTask(); 

                }
                break;
            case 13 :
                // InternalTdlLexer.g:1:110: LeftParenthesisRightParenthesisColon
                {
                mLeftParenthesisRightParenthesisColon(); 

                }
                break;
            case 14 :
                // InternalTdlLexer.g:1:147: RightParenthesisRightParenthesisColon
                {
                mRightParenthesisRightParenthesisColon(); 

                }
                break;
            case 15 :
                // InternalTdlLexer.g:1:185: Id
                {
                mId(); 

                }
                break;
            case 16 :
                // InternalTdlLexer.g:1:188: LeftParenthesisRightParenthesis
                {
                mLeftParenthesisRightParenthesis(); 

                }
                break;
            case 17 :
                // InternalTdlLexer.g:1:220: RightParenthesisRightParenthesis
                {
                mRightParenthesisRightParenthesis(); 

                }
                break;
            case 18 :
                // InternalTdlLexer.g:1:253: RightParenthesisColon
                {
                mRightParenthesisColon(); 

                }
                break;
            case 19 :
                // InternalTdlLexer.g:1:275: Apostrophe
                {
                mApostrophe(); 

                }
                break;
            case 20 :
                // InternalTdlLexer.g:1:286: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 21 :
                // InternalTdlLexer.g:1:302: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 22 :
                // InternalTdlLexer.g:1:319: Comma
                {
                mComma(); 

                }
                break;
            case 23 :
                // InternalTdlLexer.g:1:325: Colon
                {
                mColon(); 

                }
                break;
            case 24 :
                // InternalTdlLexer.g:1:331: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // InternalTdlLexer.g:1:339: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // InternalTdlLexer.g:1:348: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 27 :
                // InternalTdlLexer.g:1:360: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 28 :
                // InternalTdlLexer.g:1:376: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 29 :
                // InternalTdlLexer.g:1:392: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // InternalTdlLexer.g:1:400: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\3\26\1\35\3\26\1\44\1\26\1\46\2\uffff\1\23\2\uffff\2\23\2\uffff\2\26\1\uffff\4\26\1\uffff\1\65\1\uffff\4\26\1\74\2\uffff\1\26\10\uffff\6\26\2\uffff\5\26\3\uffff\12\26\1\123\5\26\1\uffff\1\26\1\132\1\26\2\uffff\4\26\1\uffff\1\26\2\uffff\4\26\1\145\4\26\1\uffff\11\26\1\uffff\4\26\1\167\1\26\1\171\3\uffff";
    static final String DFA12_eofS =
        "\172\uffff";
    static final String DFA12_minS =
        "\1\0\1\141\1\157\1\145\1\51\1\157\1\146\1\141\1\51\1\144\1\0\2\uffff\1\101\2\uffff\1\0\1\52\2\uffff\1\142\1\162\1\uffff\2\155\1\164\1\156\1\uffff\1\72\1\uffff\1\142\1\164\1\147\1\163\1\72\2\uffff\1\75\10\uffff\1\154\1\141\2\160\1\165\1\143\2\uffff\1\116\1\157\1\145\1\163\1\153\3\uffff\1\151\1\155\1\157\1\154\1\160\1\50\1\157\1\164\1\162\1\75\1\60\1\163\1\145\1\163\1\145\1\72\1\uffff\1\144\1\60\1\50\2\uffff\1\150\1\164\1\151\1\101\1\uffff\1\145\2\uffff\2\145\1\164\1\143\1\60\1\144\1\162\1\145\1\164\1\uffff\1\104\1\163\1\124\1\151\1\141\1\72\1\141\1\157\1\164\1\uffff\1\163\1\156\1\141\1\153\1\60\1\72\1\60\3\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\165\1\157\1\171\1\154\1\157\1\162\1\141\1\72\1\144\1\uffff\2\uffff\1\172\2\uffff\1\uffff\1\57\2\uffff\1\142\1\162\1\uffff\2\155\1\164\1\156\1\uffff\1\72\1\uffff\1\163\1\164\1\147\1\163\1\72\2\uffff\1\75\10\uffff\1\154\1\141\2\160\1\165\1\143\2\uffff\1\116\1\157\1\145\1\163\1\153\3\uffff\1\151\1\155\1\157\1\154\1\160\1\50\1\157\1\164\1\162\1\75\1\172\1\163\1\145\1\163\1\145\1\72\1\uffff\1\144\1\172\1\50\2\uffff\1\150\1\164\1\151\1\101\1\uffff\1\145\2\uffff\2\145\1\164\1\143\1\172\1\144\1\162\1\145\1\164\1\uffff\1\104\1\163\1\124\1\151\1\141\1\72\1\141\1\157\1\164\1\uffff\1\163\1\156\1\141\1\153\1\172\1\72\1\172\3\uffff";
    static final String DFA12_acceptS =
        "\13\uffff\1\26\1\27\1\uffff\1\30\1\31\2\uffff\1\35\1\36\2\uffff\1\30\4\uffff\1\5\1\uffff\1\24\5\uffff\1\22\1\25\1\uffff\1\23\1\32\1\26\1\27\1\31\1\33\1\34\1\35\6\uffff\1\15\1\20\5\uffff\1\16\1\21\1\17\20\uffff\1\13\3\uffff\1\10\1\14\4\uffff\1\11\1\uffff\1\12\1\7\11\uffff\1\6\11\uffff\1\4\7\uffff\1\3\1\1\1\2";
    static final String DFA12_specialS =
        "\1\1\11\uffff\1\0\5\uffff\1\2\151\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\23\2\22\2\23\1\22\22\23\1\22\1\23\1\20\4\23\1\12\1\4\1\10\2\23\1\13\2\23\1\21\12\17\1\14\6\23\17\16\1\1\12\16\3\23\1\15\1\16\1\23\1\6\1\16\1\2\5\16\1\11\10\16\1\5\1\3\1\7\6\16\uff85\23",
            "\1\25\23\uffff\1\24",
            "\1\27",
            "\1\31\3\uffff\1\30\17\uffff\1\32",
            "\1\34\102\uffff\1\33",
            "\1\36",
            "\1\37\13\uffff\1\40",
            "\1\41",
            "\1\42\20\uffff\1\43",
            "\1\45",
            "\0\47",
            "",
            "",
            "\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "",
            "\0\47",
            "\1\53\4\uffff\1\54",
            "",
            "",
            "\1\56",
            "\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\64",
            "",
            "\1\67\20\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "\1\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\133",
            "",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\170",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PublishedData | CompositeTask | SimpleAction | Parameters | LatLng | RosNode | After | Args | Setup | Robot | Sync | Task | LeftParenthesisRightParenthesisColon | RightParenthesisRightParenthesisColon | Id | LeftParenthesisRightParenthesis | RightParenthesisRightParenthesis | RightParenthesisColon | Apostrophe | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFF')) ) {s = 39;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='P') ) {s = 1;}

                        else if ( (LA12_0=='c') ) {s = 2;}

                        else if ( (LA12_0=='s') ) {s = 3;}

                        else if ( (LA12_0=='(') ) {s = 4;}

                        else if ( (LA12_0=='r') ) {s = 5;}

                        else if ( (LA12_0=='a') ) {s = 6;}

                        else if ( (LA12_0=='t') ) {s = 7;}

                        else if ( (LA12_0==')') ) {s = 8;}

                        else if ( (LA12_0=='i') ) {s = 9;}

                        else if ( (LA12_0=='\'') ) {s = 10;}

                        else if ( (LA12_0==',') ) {s = 11;}

                        else if ( (LA12_0==':') ) {s = 12;}

                        else if ( (LA12_0=='^') ) {s = 13;}

                        else if ( ((LA12_0>='A' && LA12_0<='O')||(LA12_0>='Q' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||(LA12_0>='d' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='q')||(LA12_0>='u' && LA12_0<='z')) ) {s = 14;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 15;}

                        else if ( (LA12_0=='\"') ) {s = 16;}

                        else if ( (LA12_0=='/') ) {s = 17;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 18;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=';' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_16 = input.LA(1);

                        s = -1;
                        if ( ((LA12_16>='\u0000' && LA12_16<='\uFFFF')) ) {s = 39;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}