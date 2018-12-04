package com.gravity.cfg.node;

import com.gravity.pe.StatementInfo;

abstract public class CFGJumpStatementNode extends CFGStatementNode {

   CFGJumpStatementNode(final StatementInfo jumpStatement) {
      super(jumpStatement);
   }
}
