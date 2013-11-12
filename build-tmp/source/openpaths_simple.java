import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class openpaths_simple extends PApplet {

/**
 * openpaths.pde
 * @author Fabian Moron Zirfas
 * simple csv reading.
 * Make sure your csv has no ","
 */
 // this is just for export purpose
Boolean writepdf = false; // if true the sketch will create a PDF


/**
 * create a bounding box world
 * upper left and lower right
 * check out http://dbsgeo.com/latlon/
 * for getting geolocations
 */
// float westlon = 180; // the most left point
// float northlat = 90; // the most top point
// float southlat = -90; // the most bottom point
// float eastlon = -180; // the most right point
/**
 * This is Potsdam bounding box
 *
 */
// float westlon = 12.935028076171875; // the most left point
// float northlat = 52.43299020014247; // the most top point
// float southlat = 52.338695481504814; // the most bottom point
// float eastlon = 13.16436767578125; // the most right point

/**
 * This is campus FHP bounding box
 */
float northlat = 52.41493264663135f; // the most top point
float westlon = 13.045835494995117f; // the most left point
float southlat = 52.40954011714691f; // the most bottom point
float eastlon = 13.054676055908203f; // the most right point



public void setup(){
    /**
   * IMPORTANT make the sketch size 2:1
   * this is equirectangular
   * see --> http://en.wikipedia.org/wiki/Equirectangular_projection
   */
  size(600, 300);
  background(255); // white bg

  String filename = "openpaths-simple.tsv";

 String lines[] = loadStrings(filename);
 println("there are " + lines.length + " lines");
 for (int i = 0 ; i < lines.length; i++) {
//   // println(lines[i]);
 }

  if(writepdf == true){
    beginRecord(PDF, "openpaths_track_01.pdf");
  }


  // float x = width * ((westlon - lon) / (westlon - eastlon));
  // float y = ( height * ((northlat - lat)/(northlat - southlat)));


  if(writepdf == true){
  endRecord();
  exit();// and end the sketch
  }
}

public void draw(){

}


class Location {
float lat,  lon,  alt;
String date,  device,  os,  version;

  Location(float lat_,float  lon_,float  alt, String date_, String  device_,String  os_,String  version_){
    lat =     lat_;
    lon =     lon_;
    alt =     alt_;
    date =     date_;
    device =     device_;
    os =     os_;
    version = version_;
  }

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "openpaths_simple" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
