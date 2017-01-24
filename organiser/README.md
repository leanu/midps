There should be an pomodoro app.

So far, the following might be the workflow:
 - [x] Create Activity where simple countdown will be shown
 - [ ] Create IntentService for background pomodoro tracking
   - [ ] Send notifications/start app/somehow notify user(by sound/vibrate/display turn on) that pomodoro is finished
   - [ ] Keep track of time passing and status, when activity will be resumed - the service will be called to check how much time remained
 - [ ] Implement switch of context(Work/Halt/Long Halt)
 - [ ] May be add tags/history of pomodoros(will need access to persistent memory)
 etc.
