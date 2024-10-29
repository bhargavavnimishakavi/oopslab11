import java.util.HashMap;
import java.util.Map;

class FigureManager {
    Figure[] figures;

    FigureManager(Figure[] figures) {
        this.figures = figures;
    }

    // Count Figures by Type
    void countFigures() {
        Map<String, Integer> figureCounts = new HashMap<>();
        for (Figure figure : figures) {
            figureCounts.merge(figure.name, 1, Integer::sum);
        }
        System.out.println("Figure counts:");
        for (Map.Entry<String, Integer> entry : figureCounts.entrySet()) {
            System.out.println(entry.getKey() + "s: " + entry.getValue());
        }
    }

    // Find Largest Areas
    void findLargestAreas() {
        Map<String, Double> largestAreas = new HashMap<>();
        for (Figure figure : figures) {
            double area = figure.getArea();
            if (!largestAreas.containsKey(figure.name) || area > largestAreas.get(figure.name)) {
                largestAreas.put(figure.name, area);
            }
        }
        System.out.println("\nLargest areas:");
        for (Map.Entry<String, Double> entry : largestAreas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Count Figures by Area
    void countFiguresByArea() {
        Map<Double, Integer> areaCounts = new HashMap<>();
        for (Figure figure : figures) {
            double area = figure.getArea();
            areaCounts.merge(area, 1, Integer::sum);
        }
        System.out.println("\nFigures with area 20.0: " + areaCounts.getOrDefault(20.0, 0));
        System.out.println("Figures with area 30.0: " + areaCounts.getOrDefault(30.0, 0));
    }

    // Replace Figures Based on Precedence
    void replaceFigures() {
        Map<Double, Figure> figuresByArea = new HashMap<>();
        for (Figure figure : figures) {
            double area = figure.getArea();
            if (!figuresByArea.containsKey(area) || figure.name.equals("Rhombus")) {
                figuresByArea.put(area, figure);
            } else if (figure.name.equals("Rectangle") && !figuresByArea.get(area).name.equals("Rhombus")) {
                figuresByArea.put(area, figure);
            } else if (figure.name.equals("Triangle") && figuresByArea.get(area).name.equals("Triangle")) {
                figuresByArea.put(area, figure);
            }
        }
        System.out.println("\nFigure with area 20.0: " + (figuresByArea.containsKey(20.0) ? figuresByArea.get(20.0).name : "Key not present"));
        System.out.println("Figure with area 30.0: " + (figuresByArea.containsKey(30.0) ? figuresByArea.get(30.0).name : "Key not present"));
    }

    // Calculate Average Areas by Figure Type
    void calculateAverageAreas() {
        Map<String, Double> totalAreas = new HashMap<>();
        Map<String, Integer> figureCounts = new HashMap<>();
        for (Figure figure : figures) {
            totalAreas.merge(figure.name, figure.getArea(), Double::sum);
            figureCounts.merge(figure.name, 1, Integer::sum);
        }
        System.out.println("\nAverage areas:");
        for (Map.Entry<String, Double> entry : totalAreas.entrySet()) {
            String type = entry.getKey();
            int count = figureCounts.getOrDefault(type, 0);
            System.out.println(type + ": " + (count > 0 ? entry.getValue() / count : "N/A"));
        }
    }
}

