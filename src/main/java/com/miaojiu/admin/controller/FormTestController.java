package com.miaojiu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.controller
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-11  10:16
 * @Description: TODO 文件上传测试
 * @Version: 1.0
 */

@Slf4j
@Controller
public class FormTestController {

    @GetMapping("form_layouts")
    public String form_layouts() {

        return "form/form_layouts.html";
    }


    /**
     * @param email:
     * @param userName:
     * @param headerImg: 自动封装上传上来的文件
     * @param photos:
     * @return java.lang.String
     * @throws
     * @Description TODO 自动封装上传上来的文件
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/11 10:40
     */

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息");
        //对传输过来的文件进行保存

        // 获取当前路径
        URL path = this.getClass().getClassLoader().getResource("loadfile");
        String pathString = path.toString();
        String realPath = pathString.substring(6);

        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File( realPath +"/"+ originalFilename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\Java\\springboot2\\boot-05-web-admin\\src\\main\\resources\\loadfile\\" + originalFilename));
                }
            }

        }
        return "main";
    }
}
