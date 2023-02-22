Read this in other launguages: [简体中文](https://github.com/urovosamples/ScanWedgeAPIsSample/blob/master/README.zh-cn.md)
# ScanWedgeAPIsSample

*This application is intended for demonstration purposes only. It is provided as-is without guarantee or warranty and may be modified to suit individual needs.*

This sample app demonstrates ScanWedge barcode scanning, configuration, scanner status and soft scan trigger using ScanWedge Intent APIs.

**ScanWedge is based on Profiles and Categorys. A Profile contains information about how ScanWedge will behave with a given application.**

**Profile information consists of:**

* Associated application
*  Reader Category configurations
*  Output Category configurations
* Format Category configurations
* Decoder Category configurations

ScanWedge includes a default Profile, Default, which is created automatically the first time ScanWedge runs.

Using Profiles, each application can have a specific ScanWedge configuration. For example, each user application can have a Profile that outputs scanned data in the required format when that application comes to the foreground. ScanWedge can be configured to process the same set of captured data differently based on the requirements of each application.

**Note: A single Profile can be associated with one or more activities or apps. However, an activity can be associated with no more than one Profile.**

# ScanWedge Intent API Programmer's Guide

ScanWedge APIs operate through Android intents, specific commands that can be used by other applications to control data capture without the need to directly access the ScanWedge UI.

For guidance on use of common ScanWedge APIs, refer to ScanWedge resources for application development and ScanWedge Samples.

**ScanWedge APIs are categorized into 3 types:**

* Configuration APIs - related to actions taken on configurations
* Query API - retrieve information or enumerate scanners
* Runtime APIs - related to functionality that can be changed at runtime

**Configuration APIs:**

* Clone Profile - Create a copy of an existing ScanWedge Profile including all settings.
* Create Profile - Create a new Profile without setting configurations.
* Delete Profile - Delete an existing Profile.
* Import Config - Import a Profile and/or Config file, which can contain multiple Profiles.
* Rename Profile - Rename an existing Profile.
* Restore Config - Reset all user-configured settings and restore ScanWedge to the factory-default settings.
* Set Config - Create, update or replace a Profile and its settings.

**Query APIs:**

* Get Active Profile - Get the name of the profile currently in use by ScanWedge.
* Get Config - Gets the PARAM_LIST settings in the specified Profile, returned as a set of value pairs or a Plug-in config bundle.
* Get ScanWedge Status - Return the ScanWedge status, enabled or disabled.
* Get Profiles List - Return the list of ScanWedge profiles.
* Get Scanner Status - Return the status of the scanner currently selected as the default.

**Runtime APIs:**

* Enable/Disable ScanWedge - Enable/disable ScanWedge on the device.
* Reset Default Profile - Reset the default profile to Default, the built-in profile used with unassociated apps.
* Soft Scan Trigger - Start, stop a software scanning trigger.
* Switch to Profile - Change the app association to the specified profile.
