import com.PizzaStore.SliceOHeaven;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args)throws Exception {
        SliceOHeaven sliceOHeaven = new SliceOHeaven();
        sliceOHeaven.takeOder("DEF-SOH-099","set meal",15.00,"orange");
        sliceOHeaven.makePizza("Mozzarella Cheese","10","6-inch");
        sliceOHeaven.processCardPayment("12345678902233");
        sliceOHeaven.specialOfTheDay("cheese pizza","pineapple","5");
    }


}