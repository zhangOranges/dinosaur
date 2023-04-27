package com.zhang.dinosaur.game.cs.jpanel;

/* @program: dinosaur
 * @description: 左侧面板--ping值监控
 * @author: csy
 * @date: 2023-04-23 15:41
 **/

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NumberUtil;
import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.common.ThreadUtils;
import com.zhang.dinosaur.game.cs.event.LoadingPingInfoEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainLeftPingInfoPanel extends JPanel implements ConnectionSucceedEventListener<LoadingPingInfoEvent> {
    private JFreeChart chart;
    private CategoryDataset dataset;

    public MainLeftPingInfoPanel() {
        super(new MigLayout("flowx,,wrap","[grow,fill]",""));
        //设置内边距
        this.setBorder( BorderFactory.createEmptyBorder(-10,-13,-10,-13) );
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
        chart.setBackgroundPaint(new Color(242,242,242));
        // set the range axis to show values from 0 to 100
        NumberAxis rangeAxis = (NumberAxis) this.chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setRange(0, 100);

        //设置横坐标隐藏
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        //不显示x轴刻度
        domainAxis.setTickMarksVisible(false);
        //不显示x轴刻度标签
        domainAxis.setTickLabelsVisible(false);
        //设置数据区背景颜色
        plot.setBackgroundPaint(new Color(242,242,242));
        //不显示数据区域边框
        plot.setOutlineVisible(false);

        // create the chart panel and add it to this panel
        ChartPanel chartPanel = new ChartPanel(this.chart);
        chartPanel.setPreferredSize(new Dimension(200, 150));
        add(chartPanel);

        //注册监听器,监听指定事件
        GContextEventBus.register(this);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 100; i++) {
            dataset.addValue(0, "Ping", i+"");
        }
        return dataset;
    }

    private void addData(double usage) {
        CategoryPlot plot = (CategoryPlot) this.chart.getPlot();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) plot.getDataset();
        String firstColumn = dataset.getColumnKey(0).toString();
        dataset.removeValue("Ping",firstColumn);
        int columnCount = dataset.getColumnCount();
        String columnKey = dataset.getColumnKey(columnCount - 1).toString();
        dataset.setValue(usage, "Ping", Integer.parseInt(columnKey) + 1+"");
        this.chart.setTitle(NumberUtil.decimalFormat("#.##",usage)+"ms");
    }

    @Override
    @Subscribe
    public void action(LoadingPingInfoEvent o) {
        //测试ping值滚动
        ThreadUtil.execAsync(()->{
            while (true) {
                // simulate CPU usage
                double usage = ThreadLocalRandom.current().nextDouble(0, 100);
                addData(usage);
                // sleep for some time before adding the next data point
                ThreadUtils.sleep(1000);
            }
        });
    }
}
