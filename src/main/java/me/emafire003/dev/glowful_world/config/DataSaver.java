package me.emafire003.dev.glowful_world.config;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.coloredglowlib.util.Color;
import me.emafire003.dev.glowful_world.GlowfulWorld;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import static me.emafire003.dev.coloredglowlib.ColoredGlowLib.LOGGER;
import static me.emafire003.dev.glowful_world.GlowfulWorld.MOD_ID;

public class DataSaver {

    public static String PATH = FabricLoader.getInstance().getConfigDir() + "/" + MOD_ID +  "/" + "glowful_world_entities_color.json";
    public static Type StringMapToken = new TypeToken<HashMap<String, String>>(){}.getType();
    public static Type entityTypeRainbowListToken = new TypeToken<List<String>>(){}.getType();

    static Gson gson = new Gson();

    public static void createFile() {
        try {
            File datafile = new File(PATH);
            if (datafile.createNewFile()) {
                write();
            }
        } catch (IOException e) {
            LOGGER.error("There was an error trying to write the data on the file!");
            e.printStackTrace();
        }
    }
    //If i just write string by string all the stuff like "minecraft:cow":"ff00dd" and the read the file line by line
    //i will be able to work it out
    public static void write() {
        try {
            FileWriter datafileWriter = new FileWriter(PATH);
            HashMap<String, String> map = GlowfulWorld.getMap();
            HashMap<String, String> tempmap = new HashMap<>();
            for(String type : map.keySet()){
                tempmap.put(type, map.get(type));
                String line = gson.toJson(tempmap) + "\n";
                datafileWriter.write(line);
                tempmap.clear();
            }
            datafileWriter.close();
        } catch (IOException e) {
            LOGGER.error("There was an error trying to save the data on the file!");
            e.printStackTrace();
        } catch (Exception e){
            LOGGER.error("There was an error while writing on the file");
            e.printStackTrace();
        }
    }


    public static void readColorsFile() throws IOException {
        //This gets the data file and puts it into a buffered reader
        BufferedReader readbuffer = new BufferedReader(new FileReader(PATH));
        //gets the first line and stores it
        String line = readbuffer.readLine();
        HashMap<String, String> tempmap;
        //When the line is null the cycle stops
        while (line != null){
            tempmap = gson.fromJson(line, StringMapToken);

            //This gets the EntityType and its value
            for(String type : tempmap.keySet()){
                //if the value is "rainbow" it will set the type of the entity to glow rainbow
                if(tempmap.get(type).equalsIgnoreCase("rainbow")){
                    ColoredGlowLib.setRainbowColorToEntityType(EntityType.get(type).get(), true);
                }
                //if it is something else it has to be a color so sets it to glow the specified color
                else{
                    ColoredGlowLib.setColorToEntityType(EntityType.get(type).get(), Color.translateFromHEX(tempmap.get(type)));
                }
            }
            line = readbuffer.readLine();
            tempmap.clear();
        }
    }

}
