package p.gordenyou.elecboardapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.smile.calendar.manager.CalendarManager;
import com.smile.calendar.view.CollapseCalendarView;

import org.joda.time.LocalDate;

import butterknife.BindView;
import butterknife.ButterKnife;
import p.gordenyou.elecboardapp.R;

public class PlanActivity extends Activity {

    @BindView(R.id.plan_calendar)
    CollapseCalendarView calendarView;
    @BindView(R.id.plan_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.plan_datetime)
    TextView datetime;

    private LocalDate selectedDate;//当前选择的日期
    private boolean weekchanged = false;//是否切换了周号
    private CalendarManager mManager;
//    private HashMap<Integer, List<Event>> eventMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);

        CollapseCalendarView.withMonthSchedule = true;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        scheduleAdapter = new ScheduleAdapter(this);
//        recyclerView.setAdapter(scheduleAdapter);
//        eventMap = new HashMap<>();
        initCalendarListener();
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//        loadData();
    }

    private void initCalendarListener() {
        selectedDate = LocalDate.now();
        mManager = new CalendarManager(LocalDate.now(),
                CalendarManager.State.MONTH, LocalDate.now().withYear(100),
                LocalDate.now().plusYears(60));
        //月份切换监听器
        mManager.setMonthChangeListener(new CalendarManager.OnMonthChangeListener() {

            @Override
            public void monthChange(String month, LocalDate mSelected) {
                datetime.setText(month);
            }

            @Override
            public void weekChange(String week, LocalDate mSelected) {//周切换

            }
        });
        calendarView.init(mManager);
        /**
         * 日期选中监听器
         */
        calendarView.setDateSelectListener(new CollapseCalendarView.OnDateSelect() {

            @Override
            public void onDateSelected(LocalDate date) {
                selectedDate = date;
//                if (eventMap.containsKey(selectedDate.getDayOfMonth())) {
//                    scheduleAdapter.setMSchedule(eventMap.get(selectedDate.getDayOfMonth()));
//                }
            }
        });

    }
}
