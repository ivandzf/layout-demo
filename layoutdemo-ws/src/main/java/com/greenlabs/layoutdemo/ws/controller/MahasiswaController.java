package com.greenlabs.layoutdemo.ws.controller;

import com.greenlabs.layoutdemo.core.common.Result;
import com.greenlabs.layoutdemo.core.entity.Mahasiswa;
import com.greenlabs.layoutdemo.core.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 9/30/17
 */
@RestController
public class MahasiswaController extends BaseController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");

        return "hello";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> findMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();
        Map<String, Object> maps = new HashMap<>();
        maps.put("data", mahasiswaService.find(mahasiswa, 0, Integer.MAX_VALUE));
        return maps;
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.POST)
    public ResponseEntity<Result> save(@RequestBody Mahasiswa mahasiswa, HttpServletRequest request, HttpServletResponse response) {
        Result result = mahasiswaService.save(mahasiswa);
        if (result.getMessage().equals(Result.SAVE_SUCCESS)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.PUT)
    public ResponseEntity<Result> update(@RequestBody Mahasiswa mahasiswa, HttpServletRequest request, HttpServletResponse response) {
        Result result = mahasiswaService.save(mahasiswa);
        if (result.getMessage().equals(Result.SAVE_SUCCESS)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.DELETE)
    public ResponseEntity<Result> delete(@RequestBody Mahasiswa mahasiswa, HttpServletRequest request, HttpServletResponse response) {
        Result result = mahasiswaService.delete(mahasiswa);
        if (result.getMessage().equals(Result.DELETE_SUCCESS)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
