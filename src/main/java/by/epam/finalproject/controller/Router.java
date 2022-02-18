package by.epam.finalproject.controller;

public class Router {
    private RouterType routerType;
    private String page;

    public Router(RouterType routerType, String page) {
        this.routerType = routerType;
        this.page = page;
    }

    public RouterType getRouterType() {
        return routerType;
    }

    public void setRouterType(RouterType routerType) {
        this.routerType = routerType;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Router router = (Router) o;

        if (routerType != router.routerType) return false;
        return page != null ? page.equals(router.page) : router.page == null;
    }

    @Override
    public int hashCode() {
        int result = routerType != null ? routerType.hashCode() : 0;
        result = 31 * result + (page != null ? page.hashCode() : 0);
        return result;
    }
}
