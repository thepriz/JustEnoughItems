package mezz.jei.plugins.forestry;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.plugins.forestry.centrifuge.CentrifugeRecipeCategory;
import mezz.jei.plugins.forestry.centrifuge.CentrifugeRecipeHandler;
import mezz.jei.plugins.forestry.centrifuge.CentrifugeRecipeMaker;
import mezz.jei.plugins.forestry.crafting.ForestryShapedRecipeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForestryPlugin implements IModPlugin {

	private final IRecipeHandler centrifugeRecipeHandler;

	public ForestryPlugin() {
		centrifugeRecipeHandler = new CentrifugeRecipeHandler();
	}

	@Override
	public Iterable<? extends IRecipeCategory> getRecipeCategories() {
		return Collections.singletonList(new CentrifugeRecipeCategory());
	}

	@Override
	public Iterable<? extends IRecipeHandler> getRecipeHandlers() {
		return Arrays.asList(
				new ForestryShapedRecipeHandler(),
				centrifugeRecipeHandler
		);
	}

	@Override
	public Iterable<Object> getRecipes() {
		List<Object> recipes = new ArrayList<Object>();

		if (centrifugeRecipeHandler.getRecipeClass() != null) {
			recipes.addAll(CentrifugeRecipeMaker.getCentrifugeRecipes());
		}

		return recipes;
	}
}