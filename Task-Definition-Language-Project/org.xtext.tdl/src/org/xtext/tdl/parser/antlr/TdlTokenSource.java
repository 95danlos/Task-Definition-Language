/*
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.parser.antlr;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.xtext.tdl.parser.antlr.internal.InternalTdlParser;

public class TdlTokenSource extends AbstractIndentationTokenSource {

	public TdlTokenSource(TokenSource delegate) {
		super(delegate);
	}

	@Override
	protected boolean shouldSplitTokenImpl(Token token) {
		// TODO Review assumption
		return token.getType() == InternalTdlParser.RULE_WS;
	}

	@Override
	protected int getBeginTokenType() {
		// TODO Review assumption
		return InternalTdlParser.RULE_BEGIN;
	}

	@Override
	protected int getEndTokenType() {
		// TODO Review assumption
		return InternalTdlParser.RULE_END;
	}

}