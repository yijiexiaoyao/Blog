package tech.acodesigner.util;

/**
 *
 */
public class PageUtil {

    private int page;
    private int pageSize;
    private int start;

    public PageUtil(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStart() {
        return (page - 1) * pageSize;
    }
}
