/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.constants.properNoun;

/**
 *
 * @author USER
 */
public class XML {

    public enum Attribute {
        ID("id"),
        NAME("name"),
        CLASS("class");
        private final String name;

        /**
         * Constructor
         * @param name 
         */
        private Attribute(String name) {
            this.name = name;
        }

        /**
         * get Attribute Name
         * @return 
         */
        public String getName() {
            return this.name;
        }
    }

    public enum XpathSelector {
        DESCENDANT_NODE("//"),
        CHILD_NODE("/"),
        ATTRIBUTE_PREFIX("[@"),
        ATTRIBUTE_INFIX("=\""),
        ATTRIBUTE_SUFFIX("\"]");
        private final String selector;

        /**
         * Constructor
         * @param selector 
         */
        private XpathSelector(String selector) {
            this.selector = selector;
        }

        /**
         * get Xpath Selector
         * @return 
         */
        public String getSelector() {
            return this.selector;
        }
    }
}
