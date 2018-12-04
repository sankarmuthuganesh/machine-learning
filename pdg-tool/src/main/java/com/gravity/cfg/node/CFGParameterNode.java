package com.gravity.cfg.node;

import com.gravity.pe.VariableInfo;

public class CFGParameterNode extends CFGNode<VariableInfo> {

   private CFGParameterNode(final VariableInfo variable) {
      super(variable);
   }
}
