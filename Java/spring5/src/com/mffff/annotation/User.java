package com.mffff.annotation;

import com.mffff.spring.Order;
import com.mffff.spring.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// �൱����xml�ļ��������˵�ǰ���<bean>
@Component
public class User {
    // ������orderʵ�����������Componentע���Զ�װ��ɹ���ԭ���ǣ� ���԰�����Ĵ��뿴��
    // private Order order = new Order��ʵ����();
    // ���������൱��ȥ����order��ʵ���࣬��װ��ɹ���
    @Autowired
    private Order order;
    public void add() {
        System.out.println("user add");
        System.out.println(order);
    }
}
