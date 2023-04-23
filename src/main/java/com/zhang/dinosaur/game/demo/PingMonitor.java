package com.zhang.dinosaur.game.demo;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

import cn.hutool.core.util.NumberUtil;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class PingMonitor extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int DELAY = 1000; // in milliseconds

    private JFreeChart chart;
    private CategoryDataset dataset;
    private int dataPointsCount = 0;

    public PingMonitor() {
        super(new MigLayout("flowx,,wrap","[grow,fill]",""));
        this.setBorder( BorderFactory.createEmptyBorder(-13,-13,-13,-13) );
        this.dataset = createDataset();

        this.chart = ChartFactory.createBarChart(
                "0ms", // chart title
                "", // domain axis label
                "", // range axis label
                this.dataset, // data
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        TextTitle title = chart.getTitle();
        title.setHorizontalAlignment(HorizontalAlignment.LEFT);
        title.setFont(new Font(null, Font.PLAIN, 11));
        // set the colors of the bars
        BarRenderer renderer = (BarRenderer) this.chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 204, 255)); // 柱子颜色
        //NumberAxis rangeAxis = (NumberAxis) this.chart.getCategoryPlot().getRangeAxis();
        //rangeAxis.setRange(0, 100);

        //设置横坐标隐藏
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);
        plot.setBackgroundPaint(Color.WHITE);

        // create the chart panel and add it to this panel
        ChartPanel chartPanel = new ChartPanel(this.chart,true);
        chartPanel.setPreferredSize(new Dimension(200, 150));
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
        this.chart.setTitle(NumberUtil.decimalFormat("#.##",usage)+"ms");
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
