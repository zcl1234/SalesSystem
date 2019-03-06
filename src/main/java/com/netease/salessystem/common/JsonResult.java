package com.netease.salessystem.common;

import org.springframework.ui.ModelMap;

/**
 * json payload
 *
 * @author zhangchenlin
 */
public class JsonResult extends ModelMap {

    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    /**
     * Create json result.
     *
     * @return the json result
     */
    public static JsonResult create() {
        return new JsonResult();
    }

    /**
     * Instantiates a new Json result.
     */
    public JsonResult() {
        this(0, "");
    }

    /**
     * Instantiates a new Json result.
     *
     * @param code    the code
     * @param message the message
     */
    public JsonResult(int code, String message) {
        addAttribute(CODE, code);
        addAttribute(MESSAGE, message);
    }

    /**
     * Sets code.
     *
     * @param code the code
     * @return the code
     */
    public JsonResult setCode(int code) {
        addAttribute(CODE, code);
        return this;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public JsonResult setMessage(String message) {
        addAttribute(MESSAGE, message);
        return this;
    }
    public JsonResult addAttribute(String attributeName, Object attributeValue){
        super.addAttribute(attributeName, attributeValue);
        return this;
    }

    /**
     * Add result json result.
     *
     * @param attributeValue the attribute value
     * @return the json result
     */
    public JsonResult addResult(Object attributeValue) {
        super.addAttribute("result", attributeValue);
        return this;
    }
}
