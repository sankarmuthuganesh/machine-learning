package com.gravity.cfg.edge;

import com.gravity.cfg.node.CFGNode;

public class CFGNormalEdge extends CFGEdge {

   CFGNormalEdge(CFGNode<?> fromNode, final CFGNode<?> toNode) {
      super(fromNode, toNode);
   }

   @Override
   public String getDependenceTypeString() {
      return "normal";
   }

   @Override
   public String getDependenceString() {
      return "";
   }
}
