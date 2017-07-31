[![](https://jitpack.io/v/fccaikai/Lucky.svg)](https://jitpack.io/#fccaikai/Lucky)
# Lucky
快速实现APP首页,支持底部3-5个tab。

----

### 截图
![](https://ws3.sinaimg.cn/large/006tNc79gy1fi2zwdihxug308w0ftdiz.gif)

----

### 使用方法

#### 引用库

在project下的```build.gradle```下添加

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

在App下的```build.gradle```下添加

```
 compile 'com.github.fccaikai:Lucky:0.1.0'
```
#### 实现

编写MainActivity 继承 ```LuckyBottomActivity```,重写```protected List<Item> getItems()``` ```protected void onItemSelected(int position) ```两个方法。

```protected List<Item> getItems()``` ：创建TAB

```protected void onItemSelected(int position) ```：TAB点击事件回调。

示例：
```
public class MainActivity extends LuckyBottomActivity {

    @Override
    protected List<Item> getItems() {
        Item love = new Item(R.drawable.ic_favorite_border_black_24dp, R.string.love);
        Item account = new Item(R.drawable.ic_account_balance_black_24dp, R.string.account);
        Item lock = new Item(R.drawable.ic_lock_open_black_24dp, R.string.lock);
        Item setting = new Item(R.drawable.setting, R.string.setting);
        List<Item> items = new ArrayList<>();
        items.add(love);
        items.add(account);
        items.add(lock);
        items.add(setting);
        items.add(account);
        return items;
    }

    @Override
    protected void onItemSelected(int position) {
        Toast.makeText(getApplicationContext(), "选中：" + position, Toast.LENGTH_SHORT).show();
    }
}
```

----

### 结束
就是这么快。

----

### LICENSE
Apache License 2.0 [LICENSE](https://github.com/fccaikai/Lucky/blob/master/LICENSE)
