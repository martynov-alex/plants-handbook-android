package ru.martynovalex.plantshandbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.martynovalex.plantshandbook.databinding.PlantItemBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    private val plantList = ArrayList<Plant>()

    class PlantHolder(card: View): RecyclerView.ViewHolder(card) {

        // Стандартный вариант
        /*private val cardImage: ImageView = card.findViewById(R.id.cardImage)
        private val cardTitle: TextView = card.findViewById(R.id.cardTitle)

        fun bind(plant: Plant) {
            cardImage.setImageResource(plant.imageId)
            cardTitle.text = plant.title
        }*/

        // Еще можно с использованием binding
        private val binding = PlantItemBinding.bind(card)

        fun bindOption(plant: Plant) {
            binding.cardImage.setImageResource(plant.imageId);
            binding.cardTitle.text = plant.title
        }

        // или
        fun bind(plant: Plant) = with (binding){
            cardImage.setImageResource(plant.imageId);
            cardTitle.text = plant.title
        }

    }

    // Создает разметку
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    // Заполняем данными
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    // Передаем кол-во элементов
    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}