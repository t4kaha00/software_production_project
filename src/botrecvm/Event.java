/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botrecvm;

/**
 *
 * @author vvaisan
 */
public class Event {
    private int type=0;
    private Object data=null;
    public Event(int type,Object data) {
        this.data = data;
        this.type = type;
    }
    public int getType() {
        return type;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object o) {
        this.data = o;
    }
    
}
