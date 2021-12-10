# scanner-client

Kotlin multiplatform library for getting metadata for playable items.
Intended as a replacement for [SMPTestHarness-BackEnd](https://github.com/bbc/SMPTestHarness-BackEnd)
that can be included as a build dependency to android/ios SMP test harnesses.

### Progress log

This is a 10% time project. 

- 10/12/21: Add content fetching, mirroring SMPTestHarness-BackEnd capabilities.
  SMP-AN integration has been tested (and works) on a local branch. Kotlin version
  dependency will need to be discussed (currenlty needs 1.5, could go down to 1.4).
  Next work should be to add individual content access methods to ScannerClient interface.
