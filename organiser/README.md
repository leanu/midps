There should be an pomodoro app.

So far, the following might be the workflow:
 - [x] Create Activity where simple countdown will be shown
 - [x ] Send notification when pomodoro is finished
 - [ ] Create IntentService for background pomodoro tracking
   - [ ] Keep track of time passing and status, when activity will be resumed - the service will be called to check how much time remained
 - [x] Implement switch of context(Work/Halt/Long Halt)
 - [ ] May be add tags/history of pomodoros(will need access to persistent memory)
 - [ ] Add activity where pomodoro time will be customized
 etc.
