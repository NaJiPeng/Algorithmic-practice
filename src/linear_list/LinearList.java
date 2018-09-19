package linear_list;

/**
 * 线性表的API
 */
public interface LinearList<T> {

    /**
     * 查询操作
     */
    int indexOf(T element);

    /**
     * 读取操作
     */
    T get(int index);

    /**
     * 修改操作
     */
    void set(int index, T element);

    /**
     * 插入操作
     */
    void insert(int index, T element);

    /**
     * 添加操作
     */
    void add(T element);

    /**
     * 删除操作
     */
    void delete(int index);

    /**
     * 清空操作
     */
    void clear();

    /**
     * 长度
     */
    int size();

    /**
     * 是否为空
     */
    boolean isEmpty();

}
