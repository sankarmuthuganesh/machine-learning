package com.gravity.cfg.node;

import com.gravity.pe.ProgramElementInfo;

public class CFGNormalNode<T extends ProgramElementInfo> extends CFGNode<T> {

   public CFGNormalNode(final T element) {
      super(element);
   }
}
