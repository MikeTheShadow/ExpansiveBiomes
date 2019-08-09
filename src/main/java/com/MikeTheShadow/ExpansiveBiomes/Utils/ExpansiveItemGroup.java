package com.MikeTheShadow.ExpansiveBiomes.Utils;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ExpansiveItemGroup extends ItemGroup
{
    public ExpansiveItemGroup()
    {
        super("expansivebiomes");
    }


    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Blocks.DIRT);
    }

}
