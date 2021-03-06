USE [ReportServer]
GO
/****** Object:  Table [dbo].[ActiveSubscriptions]    Script Date: 25/9/2558 19:56:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActiveSubscriptions](
	[ActiveID] [uniqueidentifier] NOT NULL,
	[SubscriptionID] [uniqueidentifier] NOT NULL,
	[TotalNotifications] [int] NULL,
	[TotalSuccesses] [int] NOT NULL,
	[TotalFailures] [int] NOT NULL,
 CONSTRAINT [PK_ActiveSubscriptions] PRIMARY KEY CLUSTERED 
(
	[ActiveID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Batch]    Script Date: 25/9/2558 19:56:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Batch](
	[BatchID] [uniqueidentifier] NOT NULL,
	[AddedOn] [datetime] NOT NULL,
	[Action] [varchar](32) NOT NULL,
	[Item] [nvarchar](425) NULL,
	[Parent] [nvarchar](425) NULL,
	[Param] [nvarchar](425) NULL,
	[BoolParam] [bit] NULL,
	[Content] [image] NULL,
	[Properties] [ntext] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CachePolicy]    Script Date: 25/9/2558 19:56:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CachePolicy](
	[CachePolicyID] [uniqueidentifier] NOT NULL,
	[ReportID] [uniqueidentifier] NOT NULL,
	[ExpirationFlags] [int] NOT NULL,
	[CacheExpiration] [int] NULL,
 CONSTRAINT [PK_CachePolicy] PRIMARY KEY NONCLUSTERED 
(
	[CachePolicyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Catalog]    Script Date: 25/9/2558 19:56:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[ItemID] [uniqueidentifier] NOT NULL,
	[Path] [nvarchar](425) NOT NULL,
	[Name] [nvarchar](425) NOT NULL,
	[ParentID] [uniqueidentifier] NULL,
	[Type] [int] NOT NULL,
	[Content] [image] NULL,
	[Intermediate] [uniqueidentifier] NULL,
	[SnapshotDataID] [uniqueidentifier] NULL,
	[LinkSourceID] [uniqueidentifier] NULL,
	[Property] [ntext] NULL,
	[Description] [nvarchar](512) NULL,
	[Hidden] [bit] NULL,
	[CreatedByID] [uniqueidentifier] NOT NULL,
	[CreationDate] [datetime] NOT NULL,
	[ModifiedByID] [uniqueidentifier] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[MimeType] [nvarchar](260) NULL,
	[SnapshotLimit] [int] NULL,
	[Parameter] [ntext] NULL,
	[PolicyID] [uniqueidentifier] NOT NULL,
	[PolicyRoot] [bit] NOT NULL,
	[ExecutionFlag] [int] NOT NULL,
	[ExecutionTime] [datetime] NULL,
	[SubType] [nvarchar](128) NULL,
	[ComponentID] [uniqueidentifier] NULL,
 CONSTRAINT [PK_Catalog] PRIMARY KEY NONCLUSTERED 
(
	[ItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
ALTER TABLE [dbo].[ActiveSubscriptions]  WITH NOCHECK ADD  CONSTRAINT [FK_ActiveSubscriptions_Subscriptions] FOREIGN KEY([SubscriptionID])
REFERENCES [dbo].[Subscriptions] ([SubscriptionID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ActiveSubscriptions] CHECK CONSTRAINT [FK_ActiveSubscriptions_Subscriptions]
GO
ALTER TABLE [dbo].[CachePolicy]  WITH NOCHECK ADD  CONSTRAINT [FK_CachePolicyReportID] FOREIGN KEY([ReportID])
REFERENCES [dbo].[Catalog] ([ItemID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CachePolicy] CHECK CONSTRAINT [FK_CachePolicyReportID]
GO
ALTER TABLE [dbo].[Catalog]  WITH NOCHECK ADD  CONSTRAINT [FK_Catalog_CreatedByID] FOREIGN KEY([CreatedByID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_CreatedByID]
GO
ALTER TABLE [dbo].[Catalog]  WITH NOCHECK ADD  CONSTRAINT [FK_Catalog_LinkSourceID] FOREIGN KEY([LinkSourceID])
REFERENCES [dbo].[Catalog] ([ItemID])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_LinkSourceID]
GO
ALTER TABLE [dbo].[Catalog]  WITH NOCHECK ADD  CONSTRAINT [FK_Catalog_ModifiedByID] FOREIGN KEY([ModifiedByID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_ModifiedByID]
GO
ALTER TABLE [dbo].[Catalog]  WITH NOCHECK ADD  CONSTRAINT [FK_Catalog_ParentID] FOREIGN KEY([ParentID])
REFERENCES [dbo].[Catalog] ([ItemID])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_ParentID]
GO
ALTER TABLE [dbo].[Catalog]  WITH NOCHECK ADD  CONSTRAINT [FK_Catalog_Policy] FOREIGN KEY([PolicyID])
REFERENCES [dbo].[Policies] ([PolicyID])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_Policy]
GO
