import java.util.HashMap;
import java.util.Map;

class FigureManager {
    Figure[] figures;

    FigureManager(Figure[] figures) {
        this.figures = figures;
    }

    // Count Figures by Type
    void countFigures() {

        Map<String, Integer> typeCount = new HashMap<>();
        for (Figure figure : figures) {
            typeCount.put(figure.name, typeCount.getOrDefault(figure.name, 0) + 1); 
        }
        System.out.println("Figure Counts:");
        System.out.println("Triangles: " + typeCount.getOrDefault("Triangle", 0));
        System.out.println("Rectangles: " + typeCount.getOrDefault("Rectangle", 0));
        System.out.println("Rhombuses: " + typeCount.getOrDefault("Rhombus", 0));
    }

    // Find Largest Areas
    void findLargestAreas() {

        Map<String, Double> largestAreaMap = new HashMap<>();
        for (Figure figure : figures) {
            String type = figure.getType();
            double area = figure.getArea();
            largestAreaMap.put(type, Math.max(largestAreaMap.getOrDefault(type, -1.0), area));
        }
        System.out.println("Largest Areas:");
        System.out.println("Triangle: " + largestAreaMap.getOrDefault("Triangle", -1.0));
        System.out.println("Rectangle: " + largestAreaMap.getOrDefault("Rectangle", -1.0));
        System.out.println("Rhombus: " + largestAreaMap.getOrDefault("Rhombus", -1.0));
    }

    // Count Figures by Area
    void countFiguresByArea() {

        Map<Double, Integer> areaCountMap = new HashMap<>();
        for (Figure figure : figures) {
            double area = figure.getArea();
            areaCountMap.put(area, areaCountMap.getOrDefault(area, 0) + 1);
        }
        System.out.println("Count of Figures by Area:");
        System.out.println("Area 20.0: " + areaCountMap.getOrDefault(20.0, 0));
        System.out.println("Area 30.0: " + areaCountMap.getOrDefault(30.0, 0));
    }
    }

    // Replace Figures Based on Precedence
    void replaceFigures() {

        Map<Double, Figure> areaMap = new HashMap<>();
        for (Figure figure : figures) {
            double area = figure.getArea();
            if (!areaMap.containsKey(area) || canReplace(areaMap.get(area), figure)) {
                areaMap.put(area, figure);
            }
        }
        System.out.println("Figures with areas 20.0 and 30.0:");
        System.out.println("Area 20.0: " + (areaMap.getOrDefault(20.0, null) != null 
            ? areaMap.get(20.0).getType() : "Key not present."));
        System.out.println("Area 30.0: " + (areaMap.getOrDefault(30.0, null) != null 
            ? areaMap.get(30.0).getType() : "Key not present."));
    }

    private boolean canReplace(Figure existing, Figure newFigure) {
        if (newFigure.name == "Rhombus") {
            return true; // Rhombus can replace any figure
        } else if (newFigure instanceof Rectangle) {
            return existing instanceof Rectangle || existing instanceof Triangle;
        } else if (newFigure instanceof Triangle) {
            return existing instanceof Triangle;
        }
        return false;
    }

    // Calculate Average Areas by Figure Type
    void calculateAverageAreas() {
    }
}

