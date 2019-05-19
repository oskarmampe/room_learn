package info.adavis.topsy.turvey.features.recipes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import info.adavis.topsy.turvey.R;
import info.adavis.topsy.turvey.models.Recipe;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder>
{
    private List<Recipe> recipes = Collections.emptyList();
    private Context context;

    public RecipesAdapter(Context context) {
        this.context = context;
    }

    void setRecipes (List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recipeImage;
        TextView recipeName;
        TextView recipeDescription;

        public ViewHolder (View v) {
            super(v);

            recipeImage = (ImageView) v.findViewById(R.id.recipe_image);
            recipeName = (TextView) v.findViewById(R.id.recipe_name);
            recipeDescription = (TextView) v.findViewById(R.id.recipe_description);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);

        holder.recipeName.setText(recipe.getName());
        holder.recipeDescription.setText(recipe.getDescription());

        Picasso.with(context)
               .load(recipe.getImageResourceId())
               .resize(340, 200)
               .centerCrop()
               .into(holder.recipeImage);
    }

    @Override
    public int getItemCount ()
    {
        return this.recipes.size();
    }

}
