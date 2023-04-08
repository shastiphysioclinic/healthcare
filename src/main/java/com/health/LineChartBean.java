package com.health;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@ViewScoped
public class LineChartBean {
  @Autowired
  private DataService dataService;
  private LineChartModel lineModel;

  @PostConstruct
  public void init() {
      lineModel = new LineChartModel();
      ChartData data = new ChartData();
      LineChartDataSet dataSet = new LineChartDataSet();
      Map<String,Object> lineChartValueMap = dataService.getLineChartData();
      dataSet.setData((List<Object>)lineChartValueMap.get("chartValues"));
      dataSet.setFill(false);
      dataSet.setLabel("My First Dataset");
      dataSet.setBorderColor("rgb(75, 192, 192)");
      dataSet.setTension(0.1);
      data.addChartDataSet(dataSet);
      data.setLabels((List<String>)lineChartValueMap.get("chartLabels"));
      LineChartOptions options = new LineChartOptions();
      Title title = new Title();
      title.setDisplay(true);
      title.setText("Line Chart");
      options.setTitle(title);

      lineModel.setOptions(options);
      lineModel.setData(data);

  }

  public LineChartModel getLineModel() {
      return lineModel;
  }
  
}
