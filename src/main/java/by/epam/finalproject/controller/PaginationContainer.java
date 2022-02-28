package by.epam.finalproject.controller;

import java.util.List;

public class PaginationContainer<T> {
    private List<T> items;
    private Integer itemsPerPage;

    public PaginationContainer(List<T> items, Integer itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;
    }

    public List<T> generatePageItemList(Integer pageNumber) {
        if ((pageNumber - 1) * itemsPerPage + 1 > items.size()) {
            return null;
        }
        List<T> pageItemList;
        Integer startElementIndex = (pageNumber - 1) * itemsPerPage;
        if (pageNumber * itemsPerPage <= items.size()) {
            pageItemList = items.subList(startElementIndex, startElementIndex + itemsPerPage);
        } else {
            pageItemList = items.subList(startElementIndex, items.size());
        }
        return pageItemList;
    }

    public Integer countMaxPage() {
        Integer maxPage = items.size() / itemsPerPage;
        if (items.size() % itemsPerPage != 0) {
            maxPage++;
        }
        return maxPage;
    }

}
