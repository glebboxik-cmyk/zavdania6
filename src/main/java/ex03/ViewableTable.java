package ex03;

import ex02.ViewableResult;
import ex02.View;

public class ViewableTable extends ViewableResult {
    public View getView() {
        return new ViewTable();
    }
}
