package com.server.main.item;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class ItemDaoService 
{
public static int itemsCount=5;
private static List<Item> item=new ArrayList<>();
static
{
item.add(new Item(1, "pen", new Date()));
item.add(new Item(2, "pencil", new Date()));
item.add(new Item(3, "eraser", new Date()));
item.add(new Item(4, "compass", new Date()));
item.add(new Item(5, "book", new Date()));
}
public List<Item> findAll()
{
return item;
}

public Item save(Item item)
{
if(item.getId()==null)
{
	item.setId(++itemsCount);
}
item.add(item);
return item;
}

public Item findOne(int id)
{
for(Item item:item)
{
if(item.getId()==id)
return item;
}
return null;
}
}