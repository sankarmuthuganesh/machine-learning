package com.gravity.cfg.node;

import com.gravity.pe.StatementInfo;

public class CFGBreakStatementNode extends CFGJumpStatementNode {

   public CFGBreakStatementNode(final StatementInfo breakStatement) {
      super(breakStatement);
   }
}
