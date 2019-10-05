package by.milosh.service;

import by.milosh.model.Language;
import by.milosh.model.dto.ItemDto;
import by.milosh.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDto findByCodeAndLanguage(Integer code, Language language) {
        String itemName = getItemNameByLanguage(code, language);
        List<String> attributes = getAttributesByLanguage(code, language);
        return ItemDto.builder()
                .itemName(itemName)
                .attributeNames(attributes)
                .build();
    }

    private String getItemNameByLanguage(Integer code, Language language) {
        String itemName;
        switch (language) {
            case EN:
                itemName = itemRepository.getItemNameEn(code);
                break;
            case RU:
                itemName = itemRepository.getItemNameRu(code);
                break;
            default:
                itemName = "";
        }
        return itemName;
    }

    private List<String> getAttributesByLanguage(Integer code, Language language) {
        List<String> attributes;
        switch (language) {
            case EN:
                attributes = itemRepository.getAttributesEn(code);
                break;
            case RU:
                attributes = itemRepository.getAttributesRu(code);
                break;
            default:
                attributes = new ArrayList<>();
        }
        return attributes;
    }
}
