package com.zhang.dinosaur.game.demo;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class PingMonitor extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int MAX_DATA_POINTS = 50;
    private static final int DELAY = 1000; // in milliseconds

    private JFreeChart chart;
    private CategoryDataset dataset;
    private int dataPointsCount = 0;

    public PingMonitor() {
        super();

        this.dataset = createDataset();

        this.chart = ChartFactory.createBarChart(
                "74ms", // chart title
                "", // domain axis label
                "", // range axis label
                this.dataset, // data
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );


        // set the colors of the bars
        BarRenderer renderer = (BarRenderer) this.chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(229, 255, 255)); // 柱子颜色
        //renderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_LEFT));
        chart.setBackgroundPaint(Color.WHITE);
        //chart.setBackgroundPaint(Color.WHITE);
        // set the range axis to show values from 0 to 100
        NumberAxis rangeAxis = (NumberAxis) this.chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setRange(0, 100);

        //设置横坐标隐藏
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);

        // 设置标签生成器
        CategoryItemLabelGenerator generator = new CategoryItemLabelGenerator() {
            @Override
            public String generateRowLabel(CategoryDataset dataset, int row) {
                return null;
            }

            @Override
            public String generateColumnLabel(CategoryDataset dataset, int column) {
                return null;
            }

            @Override
            public String generateLabel(CategoryDataset dataset, int row, int column) {
                // 获取最新一条数据的值
                double value = dataset.getValue(row, column).doubleValue();
                DecimalFormat df = new DecimalFormat("#.##");
                String label = df.format(value);
                return label;
            }
        };


        // create the chart panel and add it to this panel
        ChartPanel chartPanel = new ChartPanel(this.chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        add(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 100; i++) {
            dataset.addValue(ThreadLocalRandom.current().nextDouble(0, 100),
                    "CPU Usage", i+"");
        }

        return dataset;
    }

    private void addData(double usage) {
        CategoryPlot plot = (CategoryPlot) this.chart.getPlot();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) plot.getDataset();
        String firstColumn = dataset.getColumnKey(0).toString();
        dataset.removeValue("CPU Usage",firstColumn);
        int columnCount = dataset.getColumnCount();
        String columnKey = dataset.getColumnKey(columnCount - 1).toString();
        System.out.println(columnCount);
        dataset.setValue(usage, "CPU Usage", Integer.parseInt(columnKey) + 1+"");
//        this.dataPointsCount++;
//        if (this.dataPointsCount > MAX_DATA_POINTS) {
//            dataset.clear();
//            this.dataPointsCount = 0;
//        }
    }

    @Override
    public void run() {
        while (true) {
            // simulate CPU usage
            double usage = ThreadLocalRandom.current().nextDouble(0, 100);
            addData(usage);

            // sleep for some time before adding the next data point
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PingMonitor pingMonitor = new PingMonitor();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CPUMonitor");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(pingMonitor);
            frame.pack();
            frame.setVisible(true);
        });

        new Thread(pingMonitor).start();
    }
}
