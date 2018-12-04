package com.gravity.cfg.node;

import com.gravity.cfg.node.CFGPseudoNode.PseudoElement;
import com.gravity.pe.ProgramElementInfo;

public class CFGPseudoNode extends CFGNode<PseudoElement> {

   public static class PseudoElement extends ProgramElementInfo {
      PseudoElement() {
         super(0, 0);
      }
   }

   public CFGPseudoNode() {
      super(new PseudoElement());
   }
}
