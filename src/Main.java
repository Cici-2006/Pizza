import com.PizzaStore.SliceOHeaven;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args)throws Exception {
        SliceOHeaven sliceOHeaven = new SliceOHeaven();
        sliceOHeaven.specialOfTheDay("cheese pizza","pineapple","5");
        sliceOHeaven.takeOder();
        sliceOHeaven.makePizza("10");
        System.out.println(sliceOHeaven.toString());

    }


}

