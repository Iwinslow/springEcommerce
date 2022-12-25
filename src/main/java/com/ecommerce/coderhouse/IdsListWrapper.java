package com.ecommerce.coderhouse;

import java.util.List;

public class IdsListWrapper {
    private List<Long> idsList;

    public List<Long> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Long> idsList) {
        this.idsList = idsList;
    }

    public IdsListWrapper() {
    }

    public IdsListWrapper(List<Long> idsList) {
        this.idsList = idsList;
    }

    @Override
    public String toString() {
        return "IdsListWrapper [idsList=" + idsList + "]";
    }

    
}
