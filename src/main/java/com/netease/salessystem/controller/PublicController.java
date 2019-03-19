package com.netease.salessystem.controller;

import com.netease.salessystem.common.JsonResult;
import com.netease.salessystem.common.SessionKeys;
import com.netease.salessystem.domain.Image;
import com.netease.salessystem.domain.SaleContent;
import com.netease.salessystem.service.PublicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author:626hp
 * @date:2019/3/6
 * @description:
 */
@Controller
@RequestMapping("/api/public")
public class PublicController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    private PublicService publicService;

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadImage(@RequestParam MultipartFile file, HttpServletRequest request) {
//        String filename = file.getOriginalFilename();
//        filename = filename.substring(filename.lastIndexOf("\\") + 1);
//        String savePath = request.getSession().getServletContext().getRealPath("/images/") + filename;
//        String srcPath = "/images/" + filename;
//        File tempFile = new File(savePath);
//        if (!tempFile.getParentFile().exists()) {
//            tempFile.getParentFile().mkdir();
//        }
//        Image image = new Image();
//        try {
//            if (filename.substring(filename.lastIndexOf(".") + 1).equalsIgnoreCase("png")
//                    || filename.substring(filename.lastIndexOf(".") + 1).equalsIgnoreCase("jpg")
//                    || filename.substring(filename.lastIndexOf(".") + 1).equalsIgnoreCase("jpeg")) {
//
//                file.transferTo(tempFile);
//                image.setImageName(filename);
//                image.setImageSrc(srcPath);
//            }
//        } catch (Exception e) {
//            LOGGER.error("upload image error:{}", e);
//        }
        return JsonResult.create();
    }

    @RequestMapping(value = "/public_content", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult publicContent(@RequestBody SaleContent saleContent, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute(SessionKeys.ONLINE_USER);
//        publicService.insert(userName,saleContent);
        return JsonResult.create();
    }

}
