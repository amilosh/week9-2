package by.milosh.service;

import by.milosh.model.Language;
import by.milosh.model.dto.ItemDto;

public interface ItemService {

    ItemDto findByCodeAndLanguage(Integer code, Language language);
}
