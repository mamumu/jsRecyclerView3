package com.mumu.jsrecyclerview3;

import java.io.Serializable;
import java.util.List;

/**
 * author : zlf
 * date   : 2019/1/18
 * blog   :https://www.jianshu.com/u/281e9668a5a6
 */
public class TableEntity implements Serializable {


    /**
     * success : true
     * Result : {"list":[{"Table1":"我爱小狗","Table2":"我爱小猫","Table3":"我爱小兔子"},{"Table1":"我爱小狗","Table2":"我爱小猫","Table3":"我爱小兔子"},{"Table1":"我爱小狗","Table2":"我爱小猫","Table3":"我爱小兔子"},{"Table1":"我爱小狗","Table2":"我爱小猫","Table3":"我爱小兔子"},{"Table1":"我爱小狗","Table2":"我爱小猫","Table3":"我爱小兔子"}]}
     */

    private boolean success;
    private ResultBean Result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * Table1 : 我爱小狗
             * Table2 : 我爱小猫
             * Table3 : 我爱小兔子
             */

            private String Table1;
            private String Table2;
            private String Table3;

            public ListBean(String aaa, String bbb, String ccc) {
                Table1 = aaa;
                Table2 = bbb;
                Table3 = ccc;
            }

            public String getTable1() {
                return Table1;
            }

            public void setTable1(String Table1) {
                this.Table1 = Table1;
            }

            public String getTable2() {
                return Table2;
            }

            public void setTable2(String Table2) {
                this.Table2 = Table2;
            }

            public String getTable3() {
                return Table3;
            }

            public void setTable3(String Table3) {
                this.Table3 = Table3;
            }
        }
    }
}
