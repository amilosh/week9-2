package by.milosh.controller;

import by.milosh.model.Language;
import by.milosh.model.dto.ItemDto;
import by.milosh.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@RequestMapping(path = "/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/get", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemDto> getAllItems(@RequestParam Integer code, @RequestParam Language language) {
        ItemDto item = itemService.findByCodeAndLanguage(code, language);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(item);
    }
}
