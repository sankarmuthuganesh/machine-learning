package com.gravity.pdg.node;

import com.gravity.pe.ProgramElementInfo;

public abstract class PDGNormalNode<T extends ProgramElementInfo> extends PDGNode<T> {

   protected PDGNormalNode(final T element) {
      super(element);
   }
}
